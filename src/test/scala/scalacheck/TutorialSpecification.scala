import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

/**
 * Following the ScalaCheck user guide at https://github.com/rickynils/scalacheck/wiki/User-Guide
 */
object TutorialSpecification extends Properties("List") {

  property("list concatenation") = forAll { (l1: List[Int], l2: List[Int]) =>
      l1.size + l2.size == (l1 ::: l2).size }

  /**
   * Example of a failing test. Uncomment to see the test fail.
   */
  // property("int square root") = forAll { (n: Int) => scala.math.sqrt(n*n) == n }

}