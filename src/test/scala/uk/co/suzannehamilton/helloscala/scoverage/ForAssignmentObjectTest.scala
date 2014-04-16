package uk.co.suzannehamilton.helloscala.scoverage

import org.scalatest.{OneInstancePerTest, FlatSpec}

class ForAssignmentObjectTest extends FlatSpec with OneInstancePerTest {
  "ForAssignmentObject" should "split a valid ID" in {
    val result = ForAssignmentObject.splitIdUsingFor("a1")
    assert(result.isSuccess)
  }

  it should "return an error if the ID is invalid" in {
    val result = ForAssignmentObject.splitIdUsingFor("")
    assert(result.isFailure)
  }

  "Expanded version" should "split a valid ID" in {
    val result = ForAssignmentObject.splitIdUsingMap("a1")
    assert(result.isSuccess)
  }

  it should "return an error if the ID is invalid" in {
    val result = ForAssignmentObject.splitIdUsingMap("")
    assert(result.isFailure)
  }
}
