package com.yamap55.scala

object CaseSample {
  def main(args: Array[String]): Unit = {
    val x: DayOfWeek = Sunday
    //    val y = Sunday

    val dayObWeek1 = x match {
      case Sunday => 1
      case Monday => 2
      case Tuesday => 3
      case Wednesday => 4
      case Thursday => 5
      case Friday => 6
    }
    println(dayObWeek1)

    val example = Add(Lit(1), Div(Mul(Lit(2), Lit(3)), Lit(2)))
    val num = eval(example)
    println(num)

    val Point(xx, yy) = Point(10, 20)
    println("xx=" + xx + ", yy=" + yy)

    println(nextDayOfWeek(Sunday))

    val tree: Tree = Branch(1, Branch(2, Empty, Empty), Branch(3, Empty, Empty))
    //    println(tree.)
    println(max(tree))
    println(min(tree))
    println(depth(tree))

    val l = List(1, 2, 3, 4, 5).collect { case i if i % 2 == 1 => i * 2 }
    println(l)

    // PartialFunction型
    val pf: PartialFunction[Int, Int] = {
      case i if i % 2 == 1 => (i * 2)
    }

    val ll = List(1, 2, 3, 4, 5).collect(pf)
    println(ll)

    val even1: Int => Boolean = {
      case i if i % 2 == 0 => true
      case _ => false
    }
    println(even1(1))
    println(even1(2))

    val even2: Int => Boolean = (x => x match {
      case i if i % 2 == 0 => true
      case _ => false
    })
    println(even2(1))
    println(even2(2))
  }

  def max(tree: Tree): Int = tree match {
    case Branch(value, left, right) => Math.max(value, Math.max(max(left), max(right)))
    case Empty => Integer.MIN_VALUE
  }

  def min(tree: Tree): Int = tree match {
    case Branch(value, left, right) => Math.min(value, Math.min(min(left), min(right)))
    case Empty => Integer.MAX_VALUE
  }

  def depth(tree: Tree): Int = tree match {
    case Branch(value, left, right) => {
      val l = depth(left)
      val r = depth(right)
      (if (l > r) l else r) + 1
    }
    case Empty => 0
  }

  sealed abstract class Tree
  case class Branch(value: Int, left: Tree, right: Tree) extends Tree
  case object Empty extends Tree

  def nextDayOfWeek(d: DayOfWeek): DayOfWeek = {
    d match {
      case Sunday => Monday
      case Monday => Tuesday
      case Tuesday => Wednesday
      case Wednesday => Thursday
      case Thursday => Friday
      case Friday => Saturday
      case Saturday => Sunday
    }
  }

  case class Point(x: Int, y: Int)

  def eval(exp: Exp): Int = exp match {
    case Add(l, r) => eval(l) + eval(r)
    case Sub(l, r) => eval(l) - eval(r)
    case Mul(l, r) => eval(l) * eval(r)
    case Div(l, r) => eval(l) / eval(r)
    case Lit(v) => v
  }

  sealed abstract class Exp
  case class Add(lhs: Exp, rhs: Exp) extends Exp
  case class Sub(lhs: Exp, rhs: Exp) extends Exp
  case class Mul(lhs: Exp, rhs: Exp) extends Exp
  case class Div(lhs: Exp, rhs: Exp) extends Exp
  case class Lit(value: Int) extends Exp

  sealed abstract class DayOfWeek
  case object Sunday extends DayOfWeek
  case object Monday extends DayOfWeek
  case object Tuesday extends DayOfWeek
  case object Wednesday extends DayOfWeek
  case object Thursday extends DayOfWeek
  case object Friday extends DayOfWeek
  case object Saturday extends DayOfWeek
}