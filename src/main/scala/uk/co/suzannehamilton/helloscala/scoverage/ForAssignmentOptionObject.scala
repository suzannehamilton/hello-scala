package uk.co.suzannehamilton.helloscala.scoverage

object ForAssignmentOptionObject {
  def doSomething: Option[(String, String)] = {
    for {
      (foo: String, bar: String) <- Some("foo", "bar")
    } yield (foo, bar)
  }
}
