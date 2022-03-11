package com.knoldus.supervision

import akka.actor.{ActorSystem, Props}

object Application extends App {

  val system = ActorSystem("MyAS")
  val actor = system.actorOf(Props[Supervision])
  actor ! List()
  actor ! "Hiiii"
  actor ! 5
  actor ! 0
  actor ! ""

}
