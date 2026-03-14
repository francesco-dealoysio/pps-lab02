package it.unibo.pps.u02

import it.unibo.pps.u02.Lab2.checkNumber

object Lab2 extends App {

  // Task 1 (warm up), svolto da solo
  println("\n------ Test: println() ")
  println("Hello, Scala")

  // Task 2 (On “exploring autonomously” in the REPL), svolto con Thomas Testa
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

  // Task 3.a (functions), svolto con Thomas Testa
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

  // Task 3.b, svolto con Thomas Testa
  println("\n------ Test: function with match-case ")
  val empty: String => Boolean = _ == "" // predicate on strings
  println("empty(\"pippo\"): " + empty("pippo"))

  val neg: ((String => Boolean)) => (String => Boolean) = f => (s => !f(s))
  val notEmpty = neg(empty) // which type of notEmpty?

  println("notEmpty(\"foo\"): " + notEmpty("foo")) // true
  println("notEmpty(\"\"): " + notEmpty("")) // false
  println(s"notEmpty(\"foo\") && !notEmpty(\"\"): ${notEmpty("foo") && !notEmpty("")}") // false

  // Task 4 (Currying), svolto con Thomas Testa
  // x ≤ y = z
  println("\n------ Task 4 ------")
  println("val-curried")
  val p1: (x: Int) => (y: Int) => (z: Int) => Boolean = x => y => z => (x < y) && (y == z)
  println("p1(2)(3)(3): " + p1(2)(3)(3)) // true
  println("p1(2)(4)(3): " + p1(2)(4)(3)) // false
  println("p1(4)(3)(3): " + p1(4)(3)(3)) // false

  println("\nval-not curried")
  val p2: (x: Int, y: Int, z: Int) => Boolean = (x, y, z) => (x < y) && (y == z)
  println("p2(2,3,3): " + p2(2,3,3)) // true
  println("p2(2,4,3): " + p2(2,4,3)) // false
  println("p2(4,3,3): " + p2(4,3,3)) // false

  println("\ndef-curried")
  def p3(x: Int)(y: Int)(z: Int): Boolean = (x < y) && (y == z)
  println("p3(2)(3)(3): " + p3(2)(3)(3)) // true
  println("p3(2)(4)(3): " + p3(2)(4)(3)) // false
  println("p3(4)(3)(3): " + p3(4)(3)(3)) // false

  println("\ndef-not curried")
  def p4(x: Int, y: Int, z: Int): Boolean = (x < y) && (y == z)
  println("p4(2,3,3): " + p4(2,3,3)) // true
  println("p4(2,4,3): " + p4(2,4,3)) // false
  println("p4(4,3,3): " + p4(4,3,3)) // false

  // Task 5 (Create a function that implements functional compositions), svolto con Thomas Testa
  // (f ◦ g)(x) = f(g(x))
  println("\n------ Task 5 ------")
  val compose: (Int, Int => Int, Int => Int) => Int = (x, f, g) => f(g(x))

  val f: Int => Int = _ * 4
  val g: Int => Int = _ + 2
  val res = compose(2, f, g) // 4 * (2 + 2) = 16

  println("compose(2, f, g) -> \"4 * (2 + 2) = 16\": " + res)
  println("oppure")
  println("compose(2, _ * 4, _ + 2): " + compose(2, _ * 4, _ + 2)) // 21

  // Task 6 (Create a recursive function to calculate the power of a number), svolto con Thomas Testa
  println("\n------ Task 6 ------")
  def power(b: Int, e: Int): Int = e match
    case 0 => 1
    case _ => b * power(b, e - 1)

  println("power(2, 3): " + power(2, 3))
  println("power(2, 0): " + power(2, 0))

  // Task 7 (Create a function to reverse the digits of an integer using recursion), svolto con Thomas Testa


  // Task 8 ( Define a sum type Expr to represent arithmetic expressions), svolto con Thomas Testa


  // Task 9 ( Look at tasks5.Optionals), svolto con Thomas Testa


}
