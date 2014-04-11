package uk.co.suzannehamilton.helloscala.akka

import akka.actor.{LoggingFSM, ActorLogging, Actor}
import uk.co.suzannehamilton.helloscala.akka.FsmActorWithScheduledMessages._
import uk.co.suzannehamilton.helloscala.akka.ActorMessages._

class FsmActorWithScheduledMessages
  extends Actor
  with LoggingFSM[State, Data]
  with ActorLogging {

  startWith(Idle, StateData)

  when(Idle) {
    case Event(ping: Ping, _) => stay().replying("pong")
  }
}

object FsmActorWithScheduledMessages {
  sealed trait Data
  case object StateData extends Data

  sealed trait State
  case object Idle extends State
  case object Active extends State
}
