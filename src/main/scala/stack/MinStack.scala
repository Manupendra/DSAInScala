package stack

object MinStack extends App {
  private var head: Node = null

  def push(x: Int): Unit = {
    if (head == null)
      head = new Node(x, x, null)
    else
      head = new Node(x, Math.min(x, head.min), head)
  }

  def pop(): Unit = {
    head = head.next
  }

  def top(): Int = {
    head.value
  }

  def getMin(): Int = {
    head.min
  }

  private class Node(val value: Int, val min: Int, val next: Node)

}
