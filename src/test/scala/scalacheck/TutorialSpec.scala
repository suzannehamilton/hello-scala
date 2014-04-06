import org.scalacheck._

/**
 * Following the ScalaCheck user guide at https://github.com/rickynils/scalacheck/wiki/User-Guide
 */
class TutorialSpec extends Properties("List") {
  import Prop.forAll

  property("concatenation") = forAll { (l1: List[Int], l2: List[Int]) =>
      l1.size + l2.size == (l1 ::: l2).size }

  // it should "reject the square root assertion" in {
  //   val propSqrt = Prop.forAll { (n: Int) => scala.math.sqrt(n*n) == n }

  //   propSqrt.check
  // }
}