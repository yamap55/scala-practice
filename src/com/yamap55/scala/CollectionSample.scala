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
    findMethod()
    takeWhileMethod()
    countMethod()
    flatMapMethod()
    vectorMethod()
    mapClassMethod()
    setClassMethod()
  }

  //    println("--- foldRight Start ---")
  //    println("--- foldRight End ---")

  def setClassMethod() : Unit = {
    println("--- set class Start ---")

    val s1 = Set(1,1,2,2,3,3)
    println(s1)

    val s2 = s1 - 2
    println("s1 : " + s1 + ", s2 : " + s2)

    // ミュータブルを使用したい場合には別パッケージのSapを使用する。
    // イミュータブルのMapは「scala.collection.immutable.Set」
    val s3 = scala.collection.mutable.Set(1,1,2,2,3,3)

    // mutableには「-=」、「+=」が存在する。
    // 「s3 - 2」だけでは元のSetは変更されない！！
    s3 -= 2
    println("s3 : " + s3)
    s3 += 99
    println("s3 : " + s3)

    println("--- set class End ---")
  }

  def mapClassMethod(): Unit = {
    println("--- map class Start ---")

    val m1 = Map("a" -> 1, "b" -> 2, "c" -> 3)
    val m2 = m1.updated("b", 99)
    // m1はイミュータブル
    println("m1 : " + m1 + ", m2 : " + m2)

    // ミュータブルを使用したい場合には別パッケージのMapを使用する。
    // イミュータブルのMapは「scala.collection.immutable.Map」
    val m3 = scala.collection.mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    m3("b") = 99
    println(m3)

    println("--- map class End ---")
  }

  def vectorMethod(): Unit = {

    // 要素へのランダムアクセス、挿入削除どれも高速なので
    // とりあえずデフォルトはVectorで良いっぽい
    // Listを使う時はSeqを使うのが主流という記事があったが、研修資料ではListになってる。
    println("--- vector Start ---")
    val v1 = Vector(1, 2, 3, 4, 5)

    val v2 = 6 +: v1
    println(v2)

    val v3 = v1 :+ 6
    println(v3)

    val v4 = v1.updated(2, 5)
    println(v4)

    println("--- vector End ---")
  }

  def flatMapMethod(): Unit = {
    println("--- flatMap Start ---")

    val list1 = List(List(1, 2, 3), List(4, 5)).flatMap { e => e.map { g => g + 1 } }
    println(list1)

    val list2 = List(1, 2, 3).flatMap { e => List(4, 5).map { g => e * g } }
    println(list2)

    val a = Seq(Seq("hello", "world"), Seq("good", "morning")) flatMap { x => x.mkString(" ").toUpperCase }
    println(a) // StringはCharの配列として扱われる

    println("--- flatMap End ---")
  }

  def countMethod(): Unit = {
    println("--- count Start ---")
    val count1 = List(1, 2, 3, 4, 5).count(x => x % 2 == 0)
    println(count1)

    val count2 = count(List(1, 2, 3, 4, 5))(x => x % 2 == 0)
    println(count2)

    println("--- count End ---")
  }

  def count[T](list: List[T])(f: T => Boolean): Int = {
    list.foldLeft(0)((x, y) => if (f(y)) x + 1 else x)
  }

  def takeWhileMethod(): Unit = {
    println("--- takeWhile Start ---")
    val list = List(1, 2, 3, 4, 5, 6).takeWhile(x => x != 5)
    println(list)
    println("--- takeWhile End ---")
  }

  def findMethod(): Unit = {
    println("--- find Start ---")
    val num = List(1, 2, 3, 4, 5).find(x => x % 9 == 1)
    println(num)
    println("--- find End ---")
  }

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

    val a10 = 5 :: List(1, 2, 3, 4)
    println(a10)

    // 末尾への追加はListの要素数分かかるから遅い
    val a11 = List(1, 2, 3, 4) :+ 5
    println(a11)

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