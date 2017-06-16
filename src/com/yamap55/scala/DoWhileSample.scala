package com.yamap55.scala

object DoWhileSample {
  def main(args: Array[String]): Unit = {
    loopFrom0To9()
  }

  def loopFrom0To9(): Unit = {
    var i = 0
    do {
      println("i = " + i)
      i = i + 1
    } while (i < 10)
  }

}