package com.knoldus.lifecycle

import akka.actor.{ActorSystem, Kill, PoisonPill, Props}

object Application extends App {

  val system = ActorSystem("AS")
  val actor = system.actorOf(Props[LifeCycle])
  actor ! "yes"
  actor ! 10
  actor ! "no"
  actor ! List(1, 4, 2, 7)
  actor ! "I'm ready"
  actor ! Kill
//  actor ! PoisonPill
  actor ! "Is it working"

  // system.terminate()

}
