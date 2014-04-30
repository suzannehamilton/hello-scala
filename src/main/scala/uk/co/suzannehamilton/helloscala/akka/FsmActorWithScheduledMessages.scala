package uk.co.suzannehamilton.helloscala.akka

import akka.actor._
import uk.co.suzannehamilton.helloscala.akka.FsmActorWithScheduledMessages._
import uk.co.suzannehamilton.helloscala.akka.ActorMessages._

class FsmActorWithScheduledMessages
  extends Actor
  with LoggingFSM[State, Data]
  with ActorLogging {

  startWith(Active, StateData)

  when(Active) {
    case Event(Ping, _) => stay().replying("pong")
    case Event(Expire, _) => {
      self ! PoisonPill
      stay()
    }
    case Event(expiryScheduleMessage: ScheduleExpiry, _) => {
      setTimer("expiry", Expire, expiryScheduleMessage.delay, false)
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
