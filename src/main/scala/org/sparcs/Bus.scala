package org.sparcs

case class Bus(
  name: String, days: List[Int], errTime: Boolean, errDay: Boolean,
  times: List[Time], keys: List[String], stops: List[Stop]
)

case class Stop(
  arrival: Option[Int], departure: Option[Int],
  name: String, keys: List[String]
)

case class Time(
  hour: Int, min: Int
) extends Ordered[Time] {
  def +(d: Int): Time = {
    val m = min + d
    val h = hour + (if (m >= 60) 1 else 0)
    Time(if (h >= 24) h - 24 else h, if (m >= 60) m - 60 else m)
  }

  def compare(that: Time): Int = {
    def aux(t: Time): Int = t.hour * 60 + t.min
    aux(this) compare aux(that)
  }

  override val toString: String = s"${hour}시 ${min}분"
}
