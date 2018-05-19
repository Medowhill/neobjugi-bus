package org.sparcs

import java.util.Calendar

object App {
  private val DATA = "buses"

  def main(args: Array[String]) {
  	args.toList match {
	  case msg :: Nil => {
	    val ans = new Answerer(DATA)
		val now = Calendar.getInstance()
        val day = now.get(Calendar.DAY_OF_WEEK) - 2
        val hour = now.get(Calendar.HOUR_OF_DAY)
		println(ans.query(msg, day + (if (day < 0) 7 else 0) - (if (hour < 4) 1 else 0), hour, now.get(Calendar.MINUTE)))
	  }
	  case msg :: time :: Nil => {
	    val ans = new Answerer(DATA)
		val timeRegex = raw"(\d{1}),(\d{2}):(\d{2})".r
		time match {
		  case timeRegex(day, hour, min) => println(ans.query(msg, day.toInt, hour.toInt, min.toInt))
		  case _ => println("Bad time format")
		}
	  }
	  case _ => println("Wrong arguments")
	}
  }
}
