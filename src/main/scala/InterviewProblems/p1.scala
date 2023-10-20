package InterviewProblems

import scala.math

object p1 extends App {
  /**
   * array = [1,2,3,1,2,1]
   * output =[000111, 110100]
   */

  def testFunction(array: Array[Int]): Array[String] = {
    var leftString: StringBuffer = new StringBuffer()
    var rightString: StringBuffer = new StringBuffer()
    var set: scala.collection.mutable.HashSet[Int] = scala.collection.mutable.HashSet.empty
    var set1: scala.collection.mutable.HashSet[Int] = scala.collection.mutable.HashSet.empty

    for (i <- array.indices) {
      if (!set(array(i))) {
        set.add(array(i))
        leftString.append("0")
      } else {
        leftString.append("1")
      }
    }

    for (i <- array.indices.reverse) {
      if (!set1(array(i))) {
        set1.add(array(i))
        rightString.append("0")
      } else {
        rightString.append("1")
      }
    }

    Array(leftString.toString, rightString.reverse().toString)
  }
}
