package uk.co.suzannehamilton.helloscala.akka

import uk.co.suzannehamilton.helloscala.specs2.Specification
import akka.actor.ActorSystem
import akka.testkit.{ImplicitSender, TestKit}

class TimerSpec extends Specification {
  abstract class Scope
    extends TestKit(ActorSystem())
    with org.specs2.specification.Scope
    with ImplicitSender

  "A custom message be scheduled" in new Scope {
    true mustEqual true
  }
}
