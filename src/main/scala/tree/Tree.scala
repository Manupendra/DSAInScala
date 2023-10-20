package tree

import scala.annotation.tailrec

sealed abstract class Tree[+T] {
  def value: T
  def left: Tree[T]
  def right: Tree[T]
  def isEmpty: Boolean

  /**
   * Easy problems
   */
  def isLeaf: Boolean
  def collectLeaves: List[Tree[T]]
  def leafCount: Int

}

case object End extends Tree[Nothing] {
  override def value: Nothing = throw new NoSuchElementException
  override def left: Tree[Nothing] = throw new NoSuchElementException
  override def right: Tree[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true

  /**
   * Easy problems
   */
  override def isLeaf: Boolean = false
  override def collectLeaves: List[Tree[Nothing]] = List()
  override def leafCount: Int = 0
}

case class Node[+T](override val value: T, override val left: Tree[T], override val right: Tree[T]) extends Tree[T] {
  override def isEmpty: Boolean = false

  /**
   * Easy problems
   */
  override def isLeaf: Boolean = left.isEmpty && right.isEmpty
  override def collectLeaves: List[Tree[T]] = {
    /*

        _____1_____
       /           \
     __2__       __6__
    /     \     /     \
    3     4     7     8
           \
            5

       clt([1], []) =
       clt([2, 6], []) =
       clt([3,4,6], []) =
       clt([4,6], [3]) =
       clt([5,6], [3]) =
       clt([6], [5,3]) =
       clt([7,8], [5,3]) =
       clt([8], [7,5,3]) =
       clt([], [8,7,5,3]) =
       [8,7,5,3]

     */
    @tailrec
    def collectLeavesTailrec(todo: List[Tree[T]], leaves: List[Tree[T]]): List[Tree[T]] = {
      if (todo.isEmpty) leaves
      else if (todo.head.isEmpty) collectLeavesTailrec(todo.tail, leaves)
      else if (todo.head.isLeaf) collectLeavesTailrec(todo.tail, todo.head :: leaves)
      else {
        val node = todo.head
        collectLeavesTailrec(node.left :: node.right :: todo.tail, leaves)
      }
    }

    collectLeavesTailrec(List(this), List())

  }

  override def leafCount: Int = collectLeaves.length
}

object BinaryTreeProblems extends App {

  val tree = Node(1,
    Node(2,
      Node(3, End, End),
      Node(4,
        End,
        Node(5, End, End),
      )
    ),
    Node(6,
      Node(7, End, End),
      Node(8, End, End)
    )
  )

  val tree10x = Node(10,
    Node(20,
      Node(30, End, End),
      Node(40,
        End,
        Node(50, End, End),
      )
    ),
    Node(60,
      Node(70, End, End),
      Node(80, End, End)
    )
  )

  val tree10xExtra = Node(10,
    Node(20,
      Node(30, End, End),
      Node(40,
        End,
        End
      )
    ),
    Node(60,
      Node(70, End, End),
      Node(80, End, End)
    )
  )

  /**
   * Easy problems
   */
  println(tree.collectLeaves.map(_.value))
  println(tree.leafCount)
}
