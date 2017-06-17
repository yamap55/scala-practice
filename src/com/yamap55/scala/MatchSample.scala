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

  }
}