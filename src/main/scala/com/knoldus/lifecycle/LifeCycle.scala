package com.knoldus.lifecycle

import akka.actor.{Actor, ActorLogging}

class LifeCycle extends Actor with ActorLogging{

  override def preStart(): Unit = {
    println("This is the initial message before starting of Actor System")

    /***
     * Uses cases might be anything that needs to be performed before starting your actor like checking the health of database.
     */
  }

  override def postStop(): Unit =  {
    println("This is the last message and Actor System has been stopped now")

    /***
     * Uses cases for postStop may be if you want to close all the resources being used.
     */
  }

  override def receive: Receive = {
    case _ =>
      println("Message Received.")
  }

}
