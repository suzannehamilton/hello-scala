package uk.co.suzannehamilton.helloscala.akka

import akka.actor.{PoisonPill, ActorLogging, Actor}
import uk.co.suzannehamilton.helloscala.akka.ActorWithScheduledMessages._

class ActorWithScheduledMessages extends Actor with ActorLogging {
  override def receive = {
    case Expire() => self ! PoisonPill
    case Ping() => sender ! "pong"
  }
}

object ActorWithScheduledMessages {
  case class Expire()
  case class Ping()
}
