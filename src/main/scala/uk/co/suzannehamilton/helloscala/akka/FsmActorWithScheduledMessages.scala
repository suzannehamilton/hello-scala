package uk.co.suzannehamilton.helloscala.akka

import akka.actor._
import uk.co.suzannehamilton.helloscala.akka.FsmActorWithScheduledMessages._
import uk.co.suzannehamilton.helloscala.akka.ActorMessages._
import uk.co.suzannehamilton.helloscala.akka.ActorMessages.SchedulePoisonPill
import uk.co.suzannehamilton.helloscala.akka.ActorMessages.Ping
import uk.co.suzannehamilton.helloscala.akka.ActorMessages.ScheduleExpiry
import uk.co.suzannehamilton.helloscala.akka.ActorMessages.Expire
import uk.co.suzannehamilton.helloscala.akka.ActorMessages.ScheduleIdentify

class FsmActorWithScheduledMessages
  extends Actor
  with LoggingFSM[State, Data]
  with ActorLogging {

  startWith(Active, StateData)

  when(Active) {
    case Event(ping: Ping, _) => stay().replying("pong")
    case Event(expiryMessage: Expire, _) => {
      self ! PoisonPill
      stay()
    }
    case Event(expiryScheduleMessage: ScheduleExpiry, _) => {
      setTimer("expiry", Expire(), expiryScheduleMessage.delay, false)
      stay()
    }
    case Event(poisonPillScheduleMessage: SchedulePoisonPill, _) => {
      setTimer("poisonPill", PoisonPill, poisonPillScheduleMessage.delay, false)
      stay()
    }
    case Event(scheduleIdentifyMessage: ScheduleIdentify, _) => {
      setTimer(
        "identify",
        Identify(scheduleIdentifyMessage.correlator),
        scheduleIdentifyMessage.delay,
        false)
      stay()
    }
  }
}

object FsmActorWithScheduledMessages {
  sealed trait Data
  case object StateData extends Data

  sealed trait State
  case object Active extends State
}
