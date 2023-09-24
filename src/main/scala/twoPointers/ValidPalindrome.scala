package twoPointers

object ValidPalindrome extends App {
  //T.C. O(n)
  //S.C. O(1)
  def validPalindrome(string: String): Boolean = {
    def recurring(i: Int, j: Int): Boolean = {
      if (i >= j) true
      else {
        val iS = string(i).toLower
        val jS = string(j).toLower

        (iS.isLetterOrDigit, jS.isLetterOrDigit) match {
          case (false, false) => recurring(i + 1, j - 1) //Both characters are special
          case (false, true) => recurring(i + 1, j)
          case (true, false) => recurring(i, j - 1)
          case (true, true) if (iS == jS) => recurring(i + 1, j - 1)
          case _ => false
        }
      }
    }

    recurring(0, string.length - 1)
  }

}
