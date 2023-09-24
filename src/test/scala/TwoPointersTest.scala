import org.junit.Test
import org.scalatest.matchers.should.Matchers
import twoPointers.ContainerWithMostWater.maxArea
import twoPointers.ThreeSums.threeSum
import twoPointers.TrappingRainWater.trap
import twoPointers.TwoSumSortedArray.twoSum
import twoPointers.ValidPalindrome._

class TwoPointersTest extends Matchers {

  @Test
  def validPalindromeTest(): Unit = {
    validPalindrome("A man, a plan, a canal: Panama") shouldBe true
    validPalindrome("race a car") shouldBe false
  }

  @Test
  def twoSumSorted(): Unit = {
    twoSum(Array(2, 7, 11, 15), 9) shouldBe Array(1, 2)
    twoSum(Array(2, 3, 4), 6) shouldBe Array(1, 3)
  }


  @Test
  def threeSums(): Unit = {
    threeSum(Array(-1, 0, 1, 2, -1, -4)) shouldBe List(List(-1, -1, 2), List(-1, 0, 1))
    threeSum(Array(0, 1, 1)) shouldBe List.empty
  }

  @Test
  def containerMostWater(): Unit = {
    maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)) shouldBe 49
  }

  @Test
  def trappingRainWater(): Unit = {
    trap(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) shouldBe 6
  }

}
