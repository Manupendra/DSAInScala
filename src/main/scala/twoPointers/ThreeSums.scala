package twoPointers

import java.util
import scala.annotation.tailrec

object ThreeSums extends App {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val sorted = nums.sorted
    val length = nums.length


    @tailrec
    def findNextLeft(left: Int, right: Int): Int =
      if (left < right && sorted(left) == sorted(left - 1)) findNextLeft(left + 1, right)
      else left

    @tailrec
    def findThreeSum(idx: Int, left: Int, right: Int, result: List[List[Int]]): List[List[Int]] = {
      if (left >= right) result
      else {

        val sum = sorted(idx) + sorted(left) + sorted(right)

        if (sum < 0) findThreeSum(idx, left + 1, right, result)
        else if (sum > 0) findThreeSum(idx, left, right - 1, result)
        else {
          val nextRight = right - 1
          val nextLeft = findNextLeft(left + 1, nextRight)
          val newResult = result :+ List(sorted(idx), sorted(left), sorted(right))
          findThreeSum(idx, nextLeft, nextRight, newResult)
        }
      }
    }

    @tailrec
    def threeSum_(currentIdx: Int, result: List[List[Int]]): List[List[Int]] = {
      if (currentIdx >= length - 2) {
        result
      }
      else if (currentIdx == 0 || sorted(currentIdx) != sorted(currentIdx - 1)) {
        val newResult = result ++ findThreeSum(currentIdx, currentIdx + 1, length - 1, Nil)
        threeSum_(currentIdx + 1, newResult)
      }
      else {
        threeSum_(currentIdx + 1, result)
      }
    }
    threeSum_(0, Nil)
  }

}
