package com.user.remote

import com.user.remote.actorsystems.ClientActorSystem

/**
  * Created by user on 03/08/2017.
  */
object MainClient {

  def main(args: Array[String]): Unit= {

    val clientApp = new ClientActorSystem()
    val actorResult = clientApp.sendMessages()
    println(actorResult)

    Thread.sleep(1000)
    val actorResult2 = clientApp.sendMessages()
    println(actorResult2)


  }
}
