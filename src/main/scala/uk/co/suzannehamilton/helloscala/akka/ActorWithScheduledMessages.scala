package uk.co.suzannehamilton.helloscala.akka

import akka.actor.{PoisonPill, ActorLogging, Actor}
import uk.co.suzannehamilton.helloscala.akka.ActorWithScheduledMessages.Expire

class ActorWithScheduledMessages extends Actor with ActorLogging {
  override def receive = {
    case Expire => self ! PoisonPill
  }
}

object ActorWithScheduledMessages {
  case class Expire()
}
