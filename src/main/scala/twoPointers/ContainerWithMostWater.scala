package twoPointers

import scala.annotation.tailrec

object ContainerWithMostWater extends App {
  def maxArea(height: Array[Int]): Int = {
    @tailrec
    def traverse(i: Int, j: Int, maxArea: Int): Int = {
      if (i >= j) {
        maxArea
      } else {
        val area = (j - i) * Math.min(height(i), height(j))
        val newMax = if (area > maxArea) area else maxArea
        val (newI, newJ) = if (height(i) < height(j)) (i + 1, j) else (i, j - 1)
        traverse(newI, newJ, newMax)
      }
    }

    traverse(0, height.length - 1, 0)
  }
}
