package uk.co.suzannehamilton.helloscala.akka

import uk.co.suzannehamilton.helloscala.specs2.Specification
import akka.actor.ActorSystem
import akka.testkit.{TestActorRef, ImplicitSender, TestKit}
import uk.co.suzannehamilton.helloscala.akka.ActorWithScheduledMessages.{Ping, Expire}

class TimerSpec extends Specification {
  abstract class Scope
    extends TestKit(ActorSystem())
    with org.specs2.specification.Scope
    with ImplicitSender {

    val actor = TestActorRef[ActorWithScheduledMessages]
  }

  "Actor responds to pings" in new Scope {
    actor ! Ping()

    expectMsg("pong")
  }

  "Actor can be told to expire" in new Scope {
    actor ! Expire()

    actor ! Ping()

    expectNoMsg()
  }
}
