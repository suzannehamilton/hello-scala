package uk.co.suzannehamilton.helloscala.scoverage

object ForAssignmentOptionObject {
  def doSomething: Option[String] = {
    for {
      (foo: String) <- Some("foo")
    } yield foo
  }
}
