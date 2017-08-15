package com.yamap55.scala.study

import java.io.File
import scala.io.Source

object FileStudy {
  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("./resource/textSample.txt")
    source.getLines().foreach(println)
    source.close
  }
}