package com.knoldus.supervision

import akka.actor.{ActorSystem, Props}

object Application extends App {

  val system = ActorSystem("MyAS")
  val actor = system.actorOf(Props[Supervision])
  actor ! List()
  Thread.sleep(1000)
  actor ! "Hiiii"
  Thread.sleep(1000)
  actor ! 5
  Thread.sleep(1000)
  actor ! 0
  Thread.sleep(1000)
  actor ! ""
  system.terminate()

}
