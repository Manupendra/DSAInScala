import org.junit.Test
import org.scalatest.matchers.should.Matchers
import slidingWindow.longestSubstringWithoutRepeating.lengthOfLongestSubstring

class SlidingWindowTest extends Matchers {

  @Test
  def slidingWindowTest(): Unit = {
    lengthOfLongestSubstring("abcabcbb") shouldBe 3
  }

}