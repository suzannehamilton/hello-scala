package uk.co.suzannehamilton.helloscala.akka

import scala.concurrent.duration.FiniteDuration

object ActorMessages {
  case class Expire()
  case class Ping()
  case class ScheduleExpiry(delay: FiniteDuration)
  case class SchedulePoisonPill(delay: FiniteDuration)
  case class ScheduleIdentify(delay: FiniteDuration, correlator: String)
}
