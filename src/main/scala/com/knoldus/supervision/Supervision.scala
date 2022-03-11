package com.knoldus.supervision

import akka.actor.SupervisorStrategy.{Escalate, Restart, Resume, Stop, restart}
import akka.actor.{Actor, ActorLogging, OneForOneStrategy, SupervisorStrategy}

class Supervision extends Actor with ActorLogging {

  override def preStart(): Unit = {
    println("Starting System")
  }

  override def postStop(): Unit = {
    println("Shutting down the Actor System")
  }

  override val supervisorStrategy: SupervisorStrategy = OneForOneStrategy(){
    case _: NullPointerException => Restart
    case _: IllegalArgumentException => Stop
    case _: RuntimeException => Resume
    case _: Exception => Escalate
  }

  override def receive: Receive = {
    case number: Int =>
      log.info("An Integer received. Performing BODMAS")
      100/number

    case message: String  if message.length == 0 =>
      log.info("Oops! empty string found")
      throw  new NullPointerException

    case message: String if message.length > 2000 =>
      log.info("Oops! message is too big")
      throw new RuntimeException

    case list: List[String] if list.isEmpty =>
      println("ErRoR, empty list received")
      throw new IllegalArgumentException

    case list: List[String] =>
      println(s"Processing List ${list}")

    case message: String =>
      println(s"Message received $message")
  }

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println(s"Restarting the system for reason ${reason}")
  }

  override def postRestart(reason: Throwable): Unit = {
    log.info(s"System restarted as it encountered an Error with reason ${reason}")
  }

}
