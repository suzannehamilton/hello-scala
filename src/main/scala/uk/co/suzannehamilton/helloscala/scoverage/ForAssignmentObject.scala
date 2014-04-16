package uk.co.suzannehamilton.helloscala.scoverage

import scala.util.{Failure, Try}

object ForAssignmentObject {
  def splitId(id: String): Try[(String, Long)] = {
    for {
      (prefix, number) <- parseId(id)
    } yield (prefix, number)
  }

  private val idPattern = """^([a-z])(\d)$""".r

  private def parseId(id: String): Try[(String, Long)] = {
    idPattern.findFirstMatchIn(id) match {
      case Some(x) =>
        Try((x.group(1), x.group(2).toLong))
      case None =>
        Failure(new IllegalArgumentException("Did not match pattern"))
    }
  }
}
