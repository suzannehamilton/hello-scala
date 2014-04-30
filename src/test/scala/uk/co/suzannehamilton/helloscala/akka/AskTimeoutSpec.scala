package uk.co.suzannehamilton.helloscala.akka

import uk.co.suzannehamilton.helloscala.specs2.Specification
import akka.testkit.{TestActorRef, ImplicitSender, TestKit}
import akka.actor.ActorSystem
import uk.co.suzannehamilton.helloscala.akka.ActorMessages._

class AskTimeoutSpec extends Specification {
  abstract class Scope
    extends TestKit(ActorSystem())
    with org.specs2.specification.Scope
    with ImplicitSender {

    val actor = TestActorRef[ActorWhichRespondsImmediately]

    val correlator: String = "someCorrelator"
  }

  "Actor" should {
    "respond to pings" in new Scope {
      actor ! Ping
      expectMsg(Pong)
    }
  }
}
