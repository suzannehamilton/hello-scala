package uk.co.suzannehamilton.helloscala.scoverage

object ForAssignmentOptionObject {
  def getOptionValue: Option[String] = {
    for {
      // The line below has a statement marked as uncovered
      (foo: String) <- Some("foo")
    } yield foo
  }

  // This method is identical to the previous one, but the for block has been expanded to
  // a map. This method is marked as completely covered by the test.
  def getOptionValueExpandedVersion: Option[String] = (Some("foo")).map {
    case (foo: String) => foo
  }
}
