package com.yamap55.scala

object ObjectSample {
  def main(args: Array[String]): Unit = {
    Predef.println("test")
    A.aa()

    //    println(Point.apply(1, 2))

    val point991 = Point99.apply(10, 20)
    val point992 = Point99.apply(10, 20)
    println(point991 == point992)

  }
}

object A {
  def aa(): Unit = {
    println("aa")
  }
}

class Point(val x: Int, val y: Int)
object Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
}

case class Point99(xx: Int, yy: Int)

class Person(name: String, age: Int, private val weight: Int)
//object Hoge {
//  def printWeight(): Unit = {
//    val taro = new Person("Taro", 20, 70)
//    println(taro.weight)
//  }
//}
object Person {
  def printWeight(): Unit = {
    val taro = new Person("Taro", 20, 70)
    println(taro.weight)
  }
}
