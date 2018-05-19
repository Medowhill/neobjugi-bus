package org.sparcs

import spray.json._
import DefaultJsonProtocol._

object JsonParseException extends Exception

object BusJsonProtocol extends DefaultJsonProtocol {

  implicit object TimeJsonFormat extends RootJsonFormat[Time] {
    def read(value: JsValue): Time = value match {
      case JsArray(nums) => nums.toList match {
        case JsNumber(hour) :: JsNumber(min) :: Nil => Time(hour.toInt, min.toInt)
        case _ => throw JsonParseException
      }
      case _ => throw JsonParseException
    }
    def write(t: Time): JsValue = ???
  }

  implicit object StopJsonFormat extends RootJsonFormat[Stop] {
    def read(value: JsValue): Stop = value.asJsObject.getFields("time", "name", "keys") match {
      case Seq(JsObject(fields), JsString(name), JsArray(keys)) => Stop(
        fields.get("arrival") map {
          case JsNumber(arrival) => arrival.toInt
          case _ => throw JsonParseException
        }, fields.get("departure") map {
          case JsNumber(departure) => departure.toInt
          case _ => throw JsonParseException
        },
        name,
        keys.toList.map {
          case JsString(key) => key
          case _ => throw JsonParseException
        }
      )
      case _ => throw JsonParseException
    }
    def write(t: Stop): JsValue = ???
  }

  implicit object BusJsonFormat extends RootJsonFormat[Bus] {
    def read(value: JsValue): Bus = {
      value.asJsObject.getFields("name", "day", "errtime", "errday", "times", "keys", "stops") match {
        case Seq(JsString(name), JsArray(day), JsBoolean(errTime), JsBoolean(errDay), JsArray(times), JsArray(keys), JsArray(stops)) => Bus(
          name,
          day.toList.map {
            case JsNumber(num) => num.toInt
            case _ => throw JsonParseException
          },
          errTime,
          errDay,
          times.toList.map(_.convertTo[Time]),
          keys.toList.map {
            case JsString(key) => key
            case _ => throw JsonParseException
          },
          stops.toList.map(_.convertTo[Stop])
        )
        case _ => throw JsonParseException
      }
}
    def write(t: Bus): JsValue = ???
  }
}
