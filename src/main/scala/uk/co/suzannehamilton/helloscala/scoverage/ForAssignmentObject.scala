package uk.co.suzannehamilton.helloscala.scoverage

import scala.util.{Failure, Try}

object ForAssignmentObject {
  def splitId(id: String): Try[(String, String)] = {
    for {
      (prefix, suffix) <- parseId(id)
    } yield (prefix, suffix)
  }

  private def parseId(id: String): Try[(String, String)] = {
    """^([a-z])(\d)$""".r.findFirstMatchIn(id) match {
      case Some(x) =>
        Try((x.group(1), x.group(2)))
      case None =>
        Failure(new IllegalArgumentException("Did not match pattern"))
    }
  }
}
