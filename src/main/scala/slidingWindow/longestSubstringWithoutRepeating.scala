package slidingWindow

object longestSubstringWithoutRepeating extends App {
  def lengthOfLongestSubstring(s: String): Int = {
    if(s.isEmpty || s == null) 0
    else {
      val map = scala.collection.mutable.Map[Char,Int]()
      var left = 0
      var maxLength = 0

      (0 until s.length).foreach( i =>{
        // check the char exist in the map
        if (map.contains(s(i)) && left <= map(s(i))) {
          left = map(s(i)) + 1
        }
        // updated new length
        val newLength = i - left + 1
        maxLength = scala.math.max(maxLength, newLength)

        map(s(i)) = i
      }
      )

      maxLength
    }
  }
}
