package uk.co.suzannehamilton.helloscala.akka

import akka.actor.{ActorLogging, Actor}
import uk.co.suzannehamilton.helloscala.akka.ActorMessages._

class ActorWhichRespondsImmediately extends Actor with ActorLogging {
  override def receive = {
    case Ping => sender() ! Pong
  }
}
