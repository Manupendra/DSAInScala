import InterviewProblems.p1.testFunction
import org.junit.Test
import org.scalatest.matchers.should.Matchers

class InterviewProblemsTest extends Matchers {

  @Test
  def p1Test(): Unit = {
    testFunction(Array(1, 2, 3, 1, 2, 1)) shouldBe Array("000111", "110100")
  }

}
