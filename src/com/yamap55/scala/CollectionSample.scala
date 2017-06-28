package com.yamap55.scala

object CollectionSample {
  def main(args: Array[String]): Unit = {
    arrayMethod()
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