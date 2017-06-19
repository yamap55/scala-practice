package com.yamap55.scala

object TraitSample1 {
  def main(args: Array[String]): Unit = {
    val a = new ClassA("Hoge")
    a.printName()

    val a2 = new TraitA { val name = "hogehoge" }
    a2.printName()

    new ClassA1().greet()
    new ClassB1().greet()

    new ClassA2().greet()
  }
}

trait TraitA {
  val name: String
  def printName(): Unit = println(name)
}

class ClassA(val name: String) extends TraitA

trait TraitA1 {
  def greet(): Unit
}

trait TraitB1 extends TraitA1 {
  def greet(): Unit = println("B1")
}

trait TraitC1 extends TraitA1 {
  def greet(): Unit = println("C1")
}

class ClassA1 extends TraitB1 with TraitC1 {
  override def greet(): Unit = println("ClassA1")
}

class ClassB1 extends TraitB1 with TraitC1 {
  override def greet(): Unit = super[TraitB1].greet()
}

trait TraitA2 {
  def greet(): Unit
}

trait TraitB2 extends TraitA2 {
  override def greet(): Unit = println("B2")
}

trait TraitC2 extends TraitA2 {
  override def greet(): Unit = println("C2")
}

class ClassA2 extends TraitB2 with TraitC2
