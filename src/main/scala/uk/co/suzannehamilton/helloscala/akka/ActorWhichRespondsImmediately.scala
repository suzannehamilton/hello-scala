package uk.co.suzannehamilton.helloscala.akka

import akka.actor.{ActorLogging, Actor}
import uk.co.suzannehamilton.helloscala.akka.ActorMessages._
import akka.event.LoggingReceive

class ActorWhichRespondsImmediately extends Actor with ActorLogging {
  override def receive: Receive = LoggingReceive {
    case Ping => sender() ! Pong
  }
}
