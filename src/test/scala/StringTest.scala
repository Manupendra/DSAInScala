import org.junit.Test
import org.scalatest.matchers.should.Matchers
import string.Anagrams.{checkAnagrams, checkAnagrams2}
import string.CountCharacters.countCharacters
import string.ReverseWords.reverseWords

class StringTest extends Matchers {
  @Test
  def charCountTest(): Unit ={
    countCharacters("Scala") shouldBe Map('S'->1,'c'->1,'a'->2,'l'->1)
  }

  @Test
  def reverseWordsTest(): Unit ={
    reverseWords("Alice loves Scala") shouldBe "Scala loves Alice"
  }

  @Test
  def anagramTest(): Unit ={
    checkAnagrams("desserts", "stressed") shouldBe true
    checkAnagrams2("Scala", "Haskell") shouldBe false
  }
}
