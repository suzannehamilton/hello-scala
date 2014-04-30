package uk.co.suzannehamilton.helloscala.akka

import scala.concurrent.ExecutionContext.Implicits.global
import akka.pattern.{AskTimeoutException, ask}
import uk.co.suzannehamilton.helloscala.specs2.Specification
import akka.testkit.{TestActorRef, ImplicitSender, TestKit}
import akka.actor.{Status, ActorSystem}
import uk.co.suzannehamilton.helloscala.akka.ActorMessages._
import akka.util.Timeout
import scala.concurrent.duration.FiniteDuration
import java.util.concurrent.TimeUnit
import scala.util.{Try, Failure, Success}
import scala.concurrent.Await

class AskTimeoutSpec extends Specification {
  abstract class Scope
    extends TestKit(ActorSystem())
    with org.specs2.specification.Scope
    with ImplicitSender {

    implicit val timeout = Timeout(new FiniteDuration(1, TimeUnit.SECONDS))

    val actor = TestActorRef[ActorWhichRespondsImmediately]

    val correlator: String = "someCorrelator"
  }

  "Actor" should {
    "respond to pings" in new Scope {
      actor ! Ping
      expectMsg(Pong)
    }
  }

  "Ask sent to actor" should {
    "respond to pings" in new Scope {
      val response = actor ? Ping

      response.value.get mustEqual Success(Pong)
    }

    "throw AskTimeoutException if the ask does not respond" in new Scope {
      val response = actor ? "Some invalid message"

      Await.ready(response, new FiniteDuration(2, TimeUnit.SECONDS))

      response.value.get must beAnInstanceOf[Failure[AskTimeoutException]]
    }
  }
}
