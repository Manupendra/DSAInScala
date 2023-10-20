package string

import scala.annotation.tailrec

object CountCharacters {
  /*
   cc("Scala",[]) = cc("cala",[S->1])
   = cc("ala",[c->1,S->1])
   = cc("la",[a->1,c->1,S->1])
   = cc("a",[l->1,a->1,c->1,S->1])
   = cc("",[l->1,a->2,c->1,S->1])
   */
  def countCharacters(s: String): Map[Char, Int] = {
    @tailrec
    def helperCountChar(remaining: String, acc: Map[Char, Int]): Map[Char, Int] = {
      if (remaining.isEmpty) acc
      else if (acc.contains(remaining.head)) {
        val currentChar = remaining.head
        val currentOccurrence = acc(currentChar)
        helperCountChar(remaining.tail, acc + (currentChar -> (currentOccurrence + 1)))
      } else
        helperCountChar(remaining.tail, acc + (remaining.head -> 1))
    }
    helperCountChar(s,Map())
  }
}
