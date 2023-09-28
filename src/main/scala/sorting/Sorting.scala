package sorting

object Sorting extends App {

  // Insertion sort says to break the arrays into sub-arrays and sort them individually,
  // which results in a sorted array. If we had an array of size 1,
  // that would already be sorted because there is no other element to compare it to.
  // As such, we assume that the first element is sorted because we treat it as its own subarray.
  // Best case: Omega(n) Sorted Array
  // Worst case: BigO(n^2) Revered Sorted Array
  def insertionSort(array: Array[Int]): Array[Int] = {

    for (i <- array.indices) {
      val temp: Int = array(i)
      var j = i - 1
      while (j >= 0 && temp < array(j)) {
        //swap the neighbours numbers
        array(j + 1) = array(j)
        j -= 1
      }
      array(j + 1) = temp
    }
    array
  }

  /*
  * The concept behind merge sort is very simple.
  * Keep splitting the array into halves until the subarrays hit a size of one, sort them, and merge the sorted arrays,
  * which will result in an ultimate sorted array. Y
  * ou might have figured out that this sounds exactly like the fibonacci sequence using recursion, and you would be right!
  * We can, and will be using recursion to perform this.
  * Worst case - Big O(nlogn)
  * */
  // A function to merge two sorted lists
  def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
    // If either list is empty, return the other list
    case (Nil, _) => ys
    case (_, Nil) => xs
    // If the first element of xs is smaller than the first element of ys,
    // append it to the result of merging the rest of xs with ys
    case (x :: xtail, y :: ytail) =>
      if (x < y) x :: merge(xtail, ys)
      // Otherwise, append the first element of ys to the result of merging xs with the rest of ys
      else y :: merge(xs, ytail)
  }

  // A function to sort a list using merge sort
  def mergeSort(xs: List[Int]): List[Int] = {
    // Find the middle index of the list
    val n = xs.length / 2
    // If the list has less than two elements, it is already sorted
    if (n == 0) xs
    else {
      // Split the list into two sublists
      val (left, right) = xs.splitAt(n)
      // Sort each sublist recursively and merge them
      merge(mergeSort(left), mergeSort(right))
    }
  }

  def quickSort(arr: List[Int]): List[Int] = {
    // Base case: empty or singleton list is already sorted
    if (arr.length <= 1) {
      return arr
    }

    // Choose the first element as the pivot
    val pivot = arr.head

    // Partition the list into two sublists:
    // elements smaller than or equal to pivot, and elements greater than pivot
    val (smaller, greater) = arr.tail.partition(_ <= pivot)

    // Recursively sort the sublists and concatenate them with the pivot
    quickSort(smaller) ::: pivot :: quickSort(greater)
  }

  def bucketSort(arr: Array[Int]): Array[Int] = {
    // Assuming arr only contains 0, 1 or 2
    val counts = Array(0, 0, 0)

    // Count the quantity of each val in arr
    for (num <- arr) {
      counts(num) += 1
    }

    // Fill each bucket in the original array
    var i = 0
    for (n <- 0 until counts.length) {
      for (j <- 0 until counts(n)) {
        arr(i) = n
        i += 1
      }
    }
    arr
  }









}
