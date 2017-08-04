package com.user.remote.actorsystems

import akka.actor.ActorSystem
import akka.util.Timeout
import com.typesafe.config.ConfigFactory
import scala.concurrent.duration._
import scala.concurrent.duration.{Duration, MILLISECONDS}
import akka.pattern.{ask, pipe}
import scala.concurrent.{Await, ExecutionContext, Future, Promise}
/**
  * Created by user on 03/08/2017.
  */
class ClientActorSystem {

  val system = ActorSystem.apply("ClientApplication", ConfigFactory.load().getConfig("clientconf"))
  import ExecutionContext.Implicits.global
  import system.dispatcher

  implicit val timeout = Timeout(5 seconds)
  val d1 = Duration(1000, MILLISECONDS)
//  val clientChild = system.actorSelection("akka.tcp://SereverApplication@10.0.75.1:2552/user/serverActor") //LocalJob
  val clientChild = system.actorSelection("akka.tcp://SereverApplication@127.0.0.1:2552/user/serverActor")

  println("Client actor path: "+clientChild.pathString)
  Thread.sleep(1000)

  def sendMessages(): String = {
    println("in client send message")

//    val result2 = ask(clientChild, "ping").mapTo[String]
//    println(result2)
//    result2.toString

    val future = clientChild ? "ping"
    val result = Await.result(future, timeout.duration).asInstanceOf[String]
    println("Result: "+result)
    result
  }

}
