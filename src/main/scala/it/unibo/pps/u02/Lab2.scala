package it.unibo.pps.u02

object Lab2 extends App {
  println("Hello, Scala")

  // (Int, Int): input
  // => Int: tipo restituito

  var f1: (Int, Int) => Int = (a: Int, b: Int) => a + b

  var f2 = (a: Int, b: Int) => a + b

  val f4: (Int, Int) => Int = _ + _

  val f5: (Int, Int) => Int = f4

  println(s"${f1(10, 5)}, ${f4(10, 5)}")

  var somma = f5(4, 3)
  println(somma)
}
