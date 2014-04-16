package uk.co.suzannehamilton.helloscala.scoverage

import org.scalatest.{OneInstancePerTest, FlatSpec}

class ForAssignmentObjectTest extends FlatSpec with OneInstancePerTest {
  "ForAssignmentObject" should "split a valid ID" in {
    val result = ForAssignmentObject.splitId("a1")
    assert(result.isSuccess)
  }
}
