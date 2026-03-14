package it.unibo.pps.u02

object Lab2 extends App {

  // Task 1 (warm up), svolto da solo

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

  // Task 2 (functions), svolto da solo
  val positive: Int => String = _ match
      case x if x < 0 => "negative"
      case _ => "positive"

  println("\n------ Test: function with match-case ")
  println(positive(2))
  println(positive(-20))
  println(positive(0))
  // println(positive(1.2)) // raises an exception


  // Task 3 (recursion), svolto da solo


  // Task 4 (sum types, product types, modules), svolto da solo


  // Task 5 (more functional combinators), svolto da solo


}
