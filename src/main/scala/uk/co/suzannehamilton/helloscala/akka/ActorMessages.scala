package uk.co.suzannehamilton.helloscala.akka

import scala.concurrent.duration.FiniteDuration

object ActorMessages {
  case object Expire
  case object Ping
  case object Pong
  case class ScheduleExpiry(delay: FiniteDuration)
  case class SchedulePoisonPill(delay: FiniteDuration)
  case class ScheduleIdentify(delay: FiniteDuration, correlator: String)
}
