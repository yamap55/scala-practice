package com.yamap55.scala

object TraitSample2 {
  def main(args: Array[String]): Unit = {

    val r:Robot = new Robot() with HelloGreeter
    r.start()
//    r.greet()
    println(r.getClass)

    val r2:Robot2 = new Robot2() with HelloGreeter
    r2.start()
    r2.greet()
    println(r2.getClass)

  }
}

trait Greeter {
  def greet(): Unit
}

trait Robot {
  self: Greeter =>
  def start(): Unit = greet()
  override final def toString() = "Robot"
}

trait HelloGreeter extends Greeter {
  def greet(): Unit = println("hello greeter")
}

trait Robot2 extends Greeter {
  def start(): Unit = greet()
  override final def toString() = "Robot"
}
