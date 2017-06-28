package com.yamap55.scala

object CollectionSample {
  def main(args: Array[String]): Unit = {
    arrayMethod()
    rangeMethod()
  }

  def rangeMethod(): Unit = {
    println("--- Range Start ---")

    val range1 = 1 to 5
    println(range1)

    val range2 = (1 to 5).toList
    println(range2)

    val range3 = 1 until 5
    println(range3)

    val range4 = (1 until 5).toList
    println(range4)

    println("--- Range End ---")
  }

  def arrayMethod(): Unit = {
    println("--- Array Start ---")
    val arr1 = Array(1, 2, 3, 4, 5)
    println(arr1.mkString(","))

    val arr2 = Array[Int](1, 2, 3, 4, 5)
    println(arr2.mkString(","))
    arr2(0) = 7
    println(arr2.mkString(","))

    println(arr2.length)
    swapArray(arr2)(3, 4)
    println(arr2.mkString(","))

    println("--- Array End ---")
  }

  def swapArray[T](arr: Array[T])(i: Int, j: Int): Unit = {
    val a = arr(i)
    arr(i) = arr(j)
    arr(j) = a
  }
}