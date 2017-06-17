package com.yamap55.scala

import java.util.Locale

object MatchSample {
  def main(args: Array[String]): Unit = {
    val taro = "Ichiro"
    val a = taro match {
      case "Taro" | "Ichiro" => "Male"
      case "Jiro" => "Male"
      case "Hanako" => "Female"
      case _ => "all"
    }
    println(a)

    val list = List("A", "B", "C", "D", "E")
    val b = list match {
      //      case List("A", b, c, d, e) =>
      //      case List(a, "B", c, d, e) =>
      case List(a, "B", c, d, e) if a != "A" =>
        println("a = " + a)
        println("c = " + c)
        println("d = " + d)
        println("e = " + e)
      case _ =>
        println("nothing")
    }

    val list2 = List(List("A"), List("B", "C", "D", "E"))
    val c = list2 match {
      case List(a @ List("A"), x) =>
        println(a)
        println(x)
      case _ => println("nothing")
    }

    // NGパターン（よくわからない。。。Anyとsomeが意味わからん）
    //    (List("a"): Any) match {
    //      case List(a) | Some(a) =>
    //        println("ok")
    //    }

    (List("a"): Any) match {
      case List(_) | Some(_) =>
        println("ok")
    }

    val obj: AnyRef = "String Literal"
    obj match {
      case v: Integer =>
        println("Integer!")
      case v: String =>
        // キャスト済み
        println(v.toUpperCase(Locale.ENGLISH))
    }

    // JVMの制約による型のパターンマッチの落とし穴
    val obj2: Any = List("a")
    obj2 match {
      // List[Int]が表示される
      case v: List[Int] => println("List[Int]")
      case v: List[String] => println("List[String]")
    }
    obj2 match {
      case v: List[_] => println("List[_]")
    }

    // なんでエラーになるんだろう？Scalaについてわかってきたら調べる TODO
    // Exception in thread "main" scala.MatchError: List(Q, R, P, E, A) (of class scala.collection.immutable.$colon$colon)

//    var count = 0
//    while (count < 1000) {
//      new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(5).toList match {
//        case List(a, b, c, d, e) if (a == e) =>
//          println(a + b + c + d + e)
//          count = count + 1
//      }
//    }

    println("*******")

    for (count <- 1 to 1000) {
      val l = new scala.util.Random(new java.security.SecureRandom()).alphanumeric.take(5).toList match {
        case List(a, b, c, d, e) => List(a, b, c, d, a)
      }
      println(l)
    }
  }
}