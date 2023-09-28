package LinkedList

object ReverseLL extends App {


  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }
  //Two Pointers - prev and next pointers

  //TailRecursive
  def reverseList(head: ListNode): ListNode = {
    @scala.annotation.tailrec
    def loop(head: ListNode, result: ListNode): ListNode = {
      head match {
        case null => result
        case h => {
          val current = h.next
          h.next = result
          loop(current, h)
        }
      }
    }

    loop(head, null)
  }
}
