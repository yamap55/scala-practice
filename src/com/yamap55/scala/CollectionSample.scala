package com.yamap55.scala

object CollectionSample {
  def main(args: Array[String]): Unit = {
    arrayMethod()
    rangeMethod()
    listMethod()
    mkStringMethod()
    foldLeftMethod()
    foldRightMethod()
    mapMethod()
    filterMethod()
  }
  //    println("--- foldRight Start ---")
  //    println("--- foldRight End ---")

  def filterMethod(): Unit = {
    println("--- filter Start ---")
    val list1 = List(1, 2, 3, 4, 5).filter(x => x % 2 == 1)
    println(list1)

    val list2 = filter(List(1, 2, 3, 4, 5))(x => x % 2 == 1)
    println(list2)
    println("--- filter End ---")
  }

  def filter[T](list: List[T])(f: T => Boolean): List[T] = {
    list.foldLeft(Nil: List[T])((x, y) => {
      if (f(y)) y :: x else x
    }).reverse
  }

  def mapMethod(): Unit = {
    println("--- map Start ---")

    val list1 = List(1, 2, 3, 4).map(x => x * 2)
    println(list1)

    val list2 = map(List(1, 2, 3, 4))(x => x * 2)
    println(list2)

    println("--- map End ---")
  }

  def map[T, U](list: List[T])(f: T => U): List[U] = {
    //    list.foldLeft(List(): List[U])((x, y) => x.::(f(y))).reverse
    list.foldLeft(List(): List[U])((x, y) => f(y) :: x).reverse
  }

  def foldRightMethod(): Unit = {
    println("--- foldRight Start ---")
    println(List("a", "b", "c").foldLeft("")(
      (x, y) => {
        println(x + "," + y)
        x + y
      }))
    println(List("a", "b", "c").foldRight("")(
      (x, y) => {
        println(y + "," + x)
        y + x
      }))

    println(sum(List(1, 2, 3, 4)))
    println(mul(List(1, 2, 3, 4)))
    println("--- foldRight End ---")
  }
  def sum(list: List[Int]): Int = {
    list.foldRight(0)((x, y) => x + y)
  }

  def mul(list: List[Int]): Int = {
    list.foldRight(1)((x, y) => x * y)
  }

  def foldLeftMethod(): Unit = {
    println("--- foldLeft Start ---")

    println(List(1, 2, 3).foldLeft(0)((x, y) => x + y))
    println(List(1, 2, 3).foldLeft(1)((x, y) => x * y))
    println(reverse(List(1, 2, 3)))

    println("--- foldLeft End ---")
  }

  def reverse[T](list: List[T]): List[T] = {
    list.foldLeft(List(): List[T])((x, y) => y :: x)
  }

  def mkStringMethod(): Unit = {
    println("--- mkString Start ---")

    val list = List(1, 2, 3, 4, 5)
    println(list.mkString)
    //    println(List(1, 2, 3, 4, 5).mkString()) // compile error
    println(list.mkString("[", ",", "]"))

    println(joinByComma(1, 10))

    println("--- mkString End ---")
  }

  def joinByComma(num1: Int, num2: Int): String = {
    (num1 to num2).mkString(",")
  }

  def listMethod(): Unit = {
    println("--- List Start ---")
    val list = List(1, 2, 3, 4, 5)
    // list(0) = 99 // immutable

    val a1 = 1 :: Nil
    println(a1)

    val a2 = 2 :: a1
    println(a2)

    val a3 = 3 :: a2
    println(a3)

    val a4 = 4 :: a3
    println(a4)

    val a5 = 5 :: a3
    println(a5)

    val a6 = 1 :: 2 :: 3 :: 4 :: Nil
    println(a6)

    val a7 = Nil.::(4).::(3).::(2).::(1)
    println(a7)

    val a8 = List(1, 2) ++ List(3, 4)
    println(a8)

    val a9 = List(1, 2).++(List(3, 4))
    println(a9)

    println("--- List End ---")
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