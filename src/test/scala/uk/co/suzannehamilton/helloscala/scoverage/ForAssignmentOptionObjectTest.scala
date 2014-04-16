package uk.co.suzannehamilton.helloscala.scoverage

import org.scalatest.FlatSpec

class ForAssignmentOptionObjectTest extends FlatSpec {
  "ForAssigmentObject" should "return a value" in {
    val foo = ForAssignmentOptionObject.doSomething
    assert(foo === Some("foo"))
  }
}
