package twoPointers

import scala.annotation.tailrec

object TrappingRainWater extends App {
  def trap(height: Array[Int]): Int = {
    @tailrec
    def trapWaterTailRec(maxLeft: Int, maxRight: Int, result: Int, i: Int, j: Int): Int = {
      if (i > j) result
      else {
        if (maxLeft <= maxRight) { //increment left
          val current = height(i)
          val newMaxLeft = Math.max(current, maxLeft)
          trapWaterTailRec(newMaxLeft, maxRight, result + (newMaxLeft - current), i + 1, j)
        } // increment right
        else {
          val current = height(j)
          val newMaxRight = Math.max(current, maxRight)
          trapWaterTailRec(maxLeft, newMaxRight, result + (newMaxRight - current), i, j - 1)
        }
      }
    }

    if (height.isEmpty) 0
    else trapWaterTailRec(height.head, height.last, 0, 0, height.size - 1)
  }
}
