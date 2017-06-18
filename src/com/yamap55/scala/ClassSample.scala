package com.yamap55.scala

object ClassSample {
  def main(args: Array[String]): Unit = {
    //    println(new Point2(2, 3))

    //----------
    val adder = new Adder()
    println(adder.add(2)(3))

    val c = adder.add(5)_
    println(c)
    println(c(6))
    //----------
    new APrinter().print()
    new BPrinter().print()

  }
}

class Point1(_x: Int, _y: Int) {
  val x = _x
  val y = _y
}

class Point2(val x: Int, val y: Int) {
  def +(p: Point2): Point2 = {
    new Point2(x + p.x, +p.y)
  }

  def test(a: String, b: String): String = a + b

  override def toString(): String = "(" + x + ", " + y + ")"
}

class Adder {
  def add(x: Int)(y: Int): Int = x + y
}

class APrinter() {
  def print(): Unit = {
    println("A")
  }
}

class BPrinter() extends APrinter {
  override def print(): Unit = {
    println("B")
  }
}