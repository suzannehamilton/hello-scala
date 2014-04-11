package uk.co.suzannehamilton.helloscala.akka

import scala.concurrent.duration._
import uk.co.suzannehamilton.helloscala.specs2.Specification
import akka.actor.ActorSystem
import akka.testkit.{TestActorRef, ImplicitSender, TestKit}
import uk.co.suzannehamilton.helloscala.akka.ActorMessages._

class TimerSpec extends Specification {
  abstract class Scope
    extends TestKit(ActorSystem())
    with org.specs2.specification.Scope
    with ImplicitSender {

    val actor = TestActorRef[ActorWithScheduledMessages]
  }

  "Actor" should  {
    "responds to pings" in new Scope {
      actor ! Ping()

      expectMsg("pong")
    }

    "expire when sent an Expire message" in new Scope {
      actor ! Expire()

      actor ! Ping()

      expectNoMsg()
    }

    "expire after a delay when sent an ScheduleExpiry message" in new Scope {
      actor ! ScheduleExpiry(new FiniteDuration(50, MILLISECONDS))

      Thread.sleep(10)

      actor ! Ping()
      expectMsg("pong")

      Thread.sleep(100)

      actor ! Ping()

      expectNoMsg()
    }

    "expire after a delay when sent a scheduled PoisonPill" in new Scope {
      actor ! SchedulePoisonPill(new FiniteDuration(50, MILLISECONDS))

      Thread.sleep(10)

      actor ! Ping()
      expectMsg("pong")

      Thread.sleep(100)

      actor ! Ping()

      expectNoMsg()
    }
  }
}
