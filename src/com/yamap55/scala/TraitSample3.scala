package com.yamap55.scala

object TraitSample3 {

  def main(args: Array[String]): Unit = {
    (new C2).printBar()
    new C2().printBar()

    (new C3).printBar()
    (new C4).printBar()
  }
}

trait Robot3 {
  self: Greeter2 =>
  def name: String
  def start(): Unit = greet()
}
trait Greeter2 {
  self: Robot3 =>
  def greet(): Unit = println(s"My name is $name")
}

trait A2 {
  val foo: String
}

trait B2 extends A2 {
  val bar = foo + "World"
}
class C2 extends B2 {
  val foo = "Hello"

  // A2、B2、C2の順で初期化されるため、C2が初期化される前にB2が初期化される
  // その時点でbarが確定するため「nullWorld」となる。
  def printBar(): Unit = println(bar)
}

trait B3 extends A2 {
  //  lazy val bar = foo + "World"
  def bar = foo + "World"
}
class C3 extends B3 {
  val foo = "Hello"

  // lazyにより、実際に使用されるまで遅延される。
  def printBar(): Unit = println(bar)
}

class C4 extends {
  val foo = "Hello" // スーパークラスの初期化の前に呼び出される
} with B2 {
  def printBar(): Unit = println(bar)
}