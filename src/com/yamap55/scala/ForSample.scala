package com.yamap55.scala

object ForSample {
//  def main(args: Array[String]): Unit = {
//    for(x <- 1 to 5; y <- 1 until 5) {
//      println("x = " + x + " y = " + y)
//    }
//  }

//  def main(args: Array[String]): Unit = {
//    for(x <- 1 to 5; y <- 1 until 5 if x != y) {
//      println("x = " + x + " y = " + y)
//    }
//  }

  def main(args: Array[String]): Unit = {
//    for (e <- List("A", "B", "C", "D")) {
//      println(e)
//    }

//    val aa = for (e <- List("A", "B", "C", "D")) yield {
//        "Pre" + e
//    }
//    println(aa)

    for(a <- 1 to 1000; b <- 1 to 1000; c <- 1 to 1000 if (a * a == b * b + c * c)) {
//      println("a = " + a + " b = " + b + " c = " + c)
      println((a, b, c))
    }
  }

}