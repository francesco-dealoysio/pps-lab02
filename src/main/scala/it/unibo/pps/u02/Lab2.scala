package it.unibo.pps.u02

import it.unibo.pps.u02.Lab2.checkNumber

object Lab2 extends App {

  // Task 1 (warm up), svolto con Thomas Testa

  println("\n------ Test: println() ")
  println("Hello, Scala")

  // multiplication
  def mult(x: Double, y: Double): Double = x * y
  def curriedMult(x: Double)(y: Double): Double = x * y
  def curriedMult3(x: Double)(y: Double)(z: Double): Double = x * y * z

  val m1 = mult(3, 4)
  val m2 = curriedMult(3)(4)
  val m3 = curriedMult3(3)(4)(5)

  println("\n------ Test: multiplication ")
  println(mult(-100, -2))
  println(m1)
  println(m2)
  println(m3)

  // curriedMult redefinition
  def curriedMult (x: Double): Double = x * 3
  val multiplyBy3 = curriedMult(6)
  println(multiplyBy3)

  // division
  def div(x: Double, y: Double): Double = x / y
  def curriedDiv(x: Double)(y: Double): Double = x / y

  println("\n------ Test: division ")
  println(div(3,4)) // 0.75
  println(curriedDiv(2.2)(8)) // 0.275
  println(curriedDiv(0)(8)) // 0
  println(curriedDiv(0)(0)) // NaN
  println(curriedDiv(3)(0)) // Infinity

  // Task 2 (functions), svolto con Thomas Testa
  val negInt = -10
  val zero = 0
  val posInt = 5
  val noInt = 1.2

  println("\n------ Test: function literal (like lambda) with match-case ")
  val positive: Int => String = _ match
  case x if x < 0 => "negative"
  case _ => "positive"

  println(s"$negInt is ${positive(negInt)}")
  println(s"$zero is ${positive(zero)}")
  println(s"$posInt is ${positive(posInt)}")
  //println(s"$noInt is ${positive(noInt)}") // raises an exception

  println("\n------ Test: function with match-case ")
  def checkNumber(x: Int): String = x match
  case x if x < 0 => "negative"
  case _ => "positive"

  println(s"$negInt is ${checkNumber(negInt)}")
  println(s"$zero is ${checkNumber(zero)}")
  println(s"$posInt is ${checkNumber(posInt)}")

/*
  val empty: String => Boolean = _ == "" // predicate on strings
  println(empty("xxx"))
  val neg: String => String = _ == "" // predicate on strings
*/
  /*
  val notEmpty = neg(empty) // which type of notEmpty?
  notEmpty("foo") // true
  notEmpty("") // false
  notEmpty("foo") && !notEmpty("")
*/


  // Task 3 (recursion), svolto con Thomas Testa


  // Task 4 (sum types, product types, modules), svolto con Thomas Testa


  // Task 5 (more functional combinators), svolto con Thomas Testa


}
