package com.user.remote.actorsystems

import akka.actor.{ActorSystem, Props}
import akka.util.Timeout
import com.typesafe.config.ConfigFactory
import com.user.remote.actors.ServerActor

import scala.concurrent.duration._
import scala.concurrent.duration.{Duration, MILLISECONDS}
import scala.concurrent.{Await, ExecutionContext, Future, Promise}
/**
  * Created by user on 03/08/2017.
  */
class ServerActorSystem {

  val system = ActorSystem.apply("SereverApplication", ConfigFactory.load().getConfig("serverconf"))
  import ExecutionContext.Implicits.global
  import system.dispatcher

  implicit val timeout = Timeout(5 seconds)
  val d1 = Duration(1000, MILLISECONDS)

  val serverChild = system.actorOf(ServerActor.crtActor(), "serverActor")
  println("actor path: "+serverChild.path +", toString: "+serverChild.toString())

}
