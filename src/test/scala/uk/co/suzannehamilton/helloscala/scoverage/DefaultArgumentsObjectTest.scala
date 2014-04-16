package uk.co.suzannehamilton.helloscala.scoverage

import org.scalatest.{OneInstancePerTest, FlatSpec}

class DefaultArgumentsObjectTest extends FlatSpec with OneInstancePerTest {

  "DefaultArgumentsObject" should "execute the default block if no arg is given" in {
    val result = DefaultArgumentsObject.makeGreeting()
    assert(result === "Hello, world")
  }
}
