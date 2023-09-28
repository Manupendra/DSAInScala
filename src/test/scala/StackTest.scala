import org.junit.Test
import org.scalatest.matchers.should.Matchers
import stack.ValidParentheses.isValid

class StackTest extends Matchers {

  @Test
  def validParentheses(): Unit = {
    isValid("()[]{}") shouldBe true
    isValid("(]") shouldBe false
  }

}
