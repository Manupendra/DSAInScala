import org.junit.Test
import org.scalatest.matchers.should.Matchers
import sorting.Sorting.{insertionSort, mergeSort, quickSort}

class SortingTest extends Matchers {

  @Test
  def insertionSortTest(): Unit ={
    insertionSort(Array(5,2,1,3,4)) shouldBe Array(1,2,3,4,5)
  }

  @Test
  def mergeSortTest(): Unit ={
    mergeSort(List(8,3,6,1,5,9,6,2)) shouldBe List(1,2,3,5,6,6,8,9)
  }

  @Test
  def quickSortTest(): Unit = {
    quickSort(List(6,2,4,1,3)) shouldBe List(1,2,3,4,6)
  }

}
