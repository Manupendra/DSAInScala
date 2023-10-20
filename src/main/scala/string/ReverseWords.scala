package string

object ReverseWords {
  /*
    "Alice loves Scala" => "Scala loves Alice"
    "    hello      world    " => "world hello"
   */

  def reverseWords(string: String): String = {
    string.split(" ").filter(_.nonEmpty).reverse.mkString(" ")
  }

}
