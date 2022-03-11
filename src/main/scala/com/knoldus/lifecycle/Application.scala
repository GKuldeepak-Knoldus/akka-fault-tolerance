package com.knoldus.lifecycle

import akka.actor.{ActorSystem, Props}

object Application extends App {

  val system = ActorSystem("AS")
  val actor = system.actorOf(Props[LifeCycle])
  actor ! "yes"
  system.terminate()

}
