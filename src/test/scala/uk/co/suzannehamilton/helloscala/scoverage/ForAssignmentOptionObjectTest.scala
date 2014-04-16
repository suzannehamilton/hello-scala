package uk.co.suzannehamilton.helloscala.scoverage

import org.scalatest.FlatSpec

class ForAssignmentOptionObjectTest extends FlatSpec {
  "ForAssigmentObject" should "return two values" in {
    val (foo, bar) = ForAssignmentOptionObject.doSomething.get
    assert(foo === "foo")
    assert(bar === "bar")
  }
}
