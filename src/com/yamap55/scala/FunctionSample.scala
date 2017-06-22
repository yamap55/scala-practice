package com.yamap55.scala

import scala.io.Source

object FunctionSample {
  def main(args: Array[String]): Unit = {
    val add = new Function2[Int, Int, Int] {
      def apply(x: Int, y: Int): Int = x + y
    }
    println(add.apply(100, 300))
    println(add(101, 301))

    val add2 = (x: Int, y: Int) => x + y
    println(add2(102, 302))

    val addCurried = (x: Int) => ((y: Int) => x + y)
    val f1 = addCurried(103)
    println(f1(303))

    println(addCurried2(104)(304))

    println(double(1, m => m * 2))
    println(double(2, m => m * 3))
    println(double(3, m => m * 4))

    around(
      () => println("init"),
      () => println("body"),
      () => println("fin"))

  }
  def addCurried2(x: Int)(y: Int): Int = x + y

  def double(n: Int, f: Int => Int): Int = {
    f(f(n))
  }

  def around(init: () => Unit, body: () => Any, fin: () => Unit): Any = {
    init()
    try {
      body()
    } finally {
      fin()
    }
  }

  def withFile[A](filename: String)(f: Source => A): A = {
    val s = Source.fromFile(filename)
    try {
      f(s)
    } finally {
      s.close()
    }
  }

  def printFile(filename: String): Unit = {
    withFile(filename) {
      a => a.getLines().foreach(println)
    }
  }
}