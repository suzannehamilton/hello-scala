package uk.co.suzannehamilton.helloscala.akka

import akka.actor.{PoisonPill, ActorLogging, Actor}
import uk.co.suzannehamilton.helloscala.akka.ActorMessages._

class ActorWithScheduledMessages extends Actor with ActorLogging {
  import context._

  override def receive = {
    case Expire => self ! PoisonPill
    case Ping => sender ! "pong"
    case ScheduleExpiry(delay) => context.system.scheduler.scheduleOnce(delay, self, Expire)
    case SchedulePoisonPill(delay) => context.system.scheduler.scheduleOnce(delay, self, PoisonPill)
  }
}