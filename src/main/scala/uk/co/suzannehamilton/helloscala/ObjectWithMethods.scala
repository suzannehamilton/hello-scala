package uk.co.suzannehamilton.helloscala

object ObjectWithMethods {
  val RETURN_VALUE = "Return value"

  def methodWithParentheses(): String = RETURN_VALUE

  def methodWithoutParentheses: ClassWithApplyMethod = new ClassWithApplyMethod
}