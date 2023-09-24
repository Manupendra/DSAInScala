package twoPointers

import scala.annotation.tailrec

object TwoSumSortedArray extends App {
  //Using Two pointers T.C. O(n)
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    @tailrec
    def twoSumHelper(l: Int, r: Int): Array[Int] = (nums(l) + nums(r)) match {
      case `target` => Array(l + 1, r + 1)      //target match with sum of two nums
      case sum if sum < target => twoSumHelper(l + 1, r)
      case sum if sum > target => twoSumHelper(l, r - 1)
    }

    twoSumHelper(0, nums.length - 1)
  }
}
