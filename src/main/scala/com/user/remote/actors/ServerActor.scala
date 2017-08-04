package com.user.remote.actors

import akka.actor.{Actor, Props}

/**
  * Created by user on 03/08/2017.
  */
class ServerActor extends Actor{

  def receive = {
    case "ping" => {
      println("received message in server actor")
      sender ! "server-child-actor-alive"
    }
    case "kill" => {
      println("received message in server actor")
      sender ! "child actor killed"
      context.stop(context.self)
    }
    case x => {println(s"received $x at child")}
  }

}

object ServerActor{
  def crtActor(): Props = Props(new ServerActor())
}
