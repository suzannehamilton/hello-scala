package uk.co.suzannehamilton.helloscala.akka

import akka.actor.{PoisonPill, ActorLogging, Actor}
import uk.co.suzannehamilton.helloscala.akka.ActorWithScheduledMessages._
import scala.concurrent.duration.FiniteDuration

class ActorWithScheduledMessages extends Actor with ActorLogging {
  import context._

  override def receive = {
    case Expire() => self ! PoisonPill
    case Ping() => sender ! "pong"
    case ScheduleExpiry(delay) => context.system.scheduler.scheduleOnce(delay, self, Expire())
    case SchedulePoisonPill(delay) => context.system.scheduler.scheduleOnce(delay, self, PoisonPill)
  }
}

object ActorWithScheduledMessages {
  case class Expire()
  case class Ping()
  case class ScheduleExpiry(delay: FiniteDuration)
  case class SchedulePoisonPill(delay: FiniteDuration)
}
