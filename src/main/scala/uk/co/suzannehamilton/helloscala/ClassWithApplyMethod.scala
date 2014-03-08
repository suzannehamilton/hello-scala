package uk.co.suzannehamilton.helloscala

class ClassWithApplyMethod {
  def apply(): String = ClassWithApplyMethod.RETURN_VALUE
}

object ClassWithApplyMethod {
  val RETURN_VALUE = "Some other return value"
}