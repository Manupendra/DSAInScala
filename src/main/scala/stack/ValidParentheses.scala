package stack

import scala.annotation.tailrec

object ValidParentheses extends App {
  def isValid(s: String): Boolean = {

    import scala.collection.mutable

    val pairs = Map(')' -> '(', '}' -> '{', ']' -> '[')
    val stack = new mutable.Stack[Char](s.length)

    s.foreach {
      // Got a closing bracket
      case c if pairs.contains(c) =>
        if (stack.isEmpty || pairs(c) != stack.pop()) return false

      // Got an opening bracket
      case c => stack.push(c)
    }
    stack.isEmpty
  }
}
