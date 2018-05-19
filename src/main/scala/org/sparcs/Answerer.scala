package org.sparcs

import Data.readFile

import spray.json._
import BusJsonProtocol._

class Answerer(file: String) {

  private val buses: List[Bus] = readFile(file).map(
    _.split("\n").toList.flatMap(
      readFile(_)
    ).map(
      _.parseJson.convertTo[Bus]
    )
  ).getOrElse(List())

  def query(msg: String, day: Int, hour: Int, min: Int): String = {
    val nmsg = normalize(msg)

    def answerBus(bus: Bus): Option[String] = {
      bus.keys.flatMap(k => 
        if (nmsg.contains(k)) Some(nmsg.replace(k, "")) else None
      ).headOption.flatMap(m => {
        if (bus.days.contains(day)) {
          def answerStop(stop: Stop): Option[String] = {
            if (stop.keys.exists(m.contains(_))) {
              val result = List((stop.arrival, ARRIVAL_STRING), (stop.departure, DEPARTURE_STRING)).flatMap {
                case (Some(d), res) => {
                  val times = bus.times.map(_ + d).filter(Time(hour, min) < _)
                  if (times.isEmpty)
                    if (bus.errTime) Some(String.format(ERR_TIME_STRING, addJosa(bus.name), stop.name)) else None
                  else
                    Some(String.format(
                      res,
                      addJosa(bus.name),
                      times.take(3).mkString(", ") + (if (times.size > 3) OMITTING_STRING else ""),
                      stop.name
                    ))
                }
                case (None, _) => None
              }
              if (result.isEmpty) None else Some(result.mkString("\n"))
            } else None
          }

          val stopAns = bus.stops.flatMap(answerStop(_))
          Some(
            if (stopAns.isEmpty)
              String.format(ERR_STOP_STRING, bus.name, addJosa(bus.name), bus.stops.map(_.name).mkString(", "))
            else
              stopAns.mkString("\n")
          )
        } else
          if (bus.errDay) Some(String.format(ERR_DAY_STRING, addJosa(bus.name))) else None
      })
    }

    buses.flatMap(answerBus(_)).mkString("\n")
  }

  private def normalize(msg: String): String = msg.replace(" ", "").replace("\t", "").replace("\n", "").toLowerCase
  private def addJosa(str: String): String = str + (if ((str.last - 44032) % 28 != 0) "은" else "는")

  private val ERR_STOP_STRING = "%s의 도착 시간을 알고 싶은 정류장의 이름을 정확히 말씀해주세요. %s %s에 갑니다."
  private val ERR_TIME_STRING = "%s 오늘 더이상 %s에 오지 않습니다."
  private val ERR_DAY_STRING = "%s 오늘 운행하지 않습니다."
  private val ARRIVAL_STRING = "%s %s에 %s에 도착할 예정입니다."
  private val DEPARTURE_STRING = "%s %s에 %s에서 출발할 예정입니다."
  private val OMITTING_STRING = "..."
}
