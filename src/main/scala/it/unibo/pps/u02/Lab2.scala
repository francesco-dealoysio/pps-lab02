package it.unibo.pps.u02

import it.unibo.pps.u02.Lab2.checkNumber

object Lab2 extends App {

  // Task 1 (warm up), svolto da solo
  //println("Hello, Scala")

  // Task 2 (On “exploring autonomously” in the REPL), svolto con Thomas Testa

  /* multiplication */
  def mult(x: Double, y: Double): Double = x * y
  def curriedMult(x: Double)(y: Double): Double = x * y
  def curriedMult3(x: Double)(y: Double)(z: Double): Double = x * y * z

  /* curriedMult redefinition */
  def curriedMult(x: Double): Double = x * 3
  val multiplyBy3 = curriedMult(6)

  /* division function */
  def div(x: Double, y: Double): Double = x / y

  /* division function carried version */
  def curriedDiv(x: Double)(y: Double): Double = x / y

  // Task 3.a (functions), svolto con Thomas Testa

  /* function literal (like lambda) with match-case */
  val positive: Int => String = _ match
    case x if x < 0 => "negative"
    case _ => "positive"

  /* function with match-case */
  def checkNumber(x: Int): String = x match
    case x if x < 0 => "negative"
    case _ => "positive"

  // Task 3.b, svolto con Thomas Testa

  /* function accepting predicate string */
  val empty: String => Boolean = _ == ""

  val neg: ((String => Boolean)) => (String => Boolean) = f => (s => !f(s))
  val notEmpty = neg(empty) // which type of notEmpty?

  // Task 4 (Currying), svolto con Thomas Testa
  // check if x ≤ y = z

  /* val-curried deslcaration */
  val p1: (x: Int) => (y: Int) => (z: Int) => Boolean =
    x => y => z =>
      x <= y && y == z

  /* val-not curried declaration */
  val p2: (x: Int, y: Int, z: Int) => Boolean =
    (x, y, z) =>
      x <= y && y == z

  /* def-curried declatation */
  def p3(x: Int)(y: Int)(z: Int): Boolean =
    x <= y && y == z

  /* def-not curried declaration */
  def p4(x: Int, y: Int, z: Int): Boolean =
    x <= y && y == z

  // Task 5 (Create a function that implements functional compositions), svolto con Thomas Testa
  // (f ◦ g)(x) = f(g(x))

  /* function declaration */
  val compose: (Int, Int => Int, Int => Int) => Int = (x, f, g) => f(g(x))

  val f: Int => Int = _ * 4
  val g: Int => Int = _ + 2
  val res = compose(2, f, g) // 4 * (2 + 2) = 16

  // Task 6 (Create a recursive function to calculate the power of a number), svolto con Thomas Testa

  /* recursive function with match-case */
  def power(b: Double, e: Int): Double = e match
    case 0 => 1
    case _ => b * power(b, e - 1)

  /* tail-recursive version of power */
  def powerTail(base: Double, exponent: Int): Double =
    @annotation.tailrec
    def loop(exp: Int, acc: Double): Double =
      if exp == 0 then
        acc
      else
        loop(exp - 1, acc * base)
    loop(exponent, 1.0)

  // Task 7 (Create a function to reverse the digits of an integer using recursion), svolto con Thomas Testa

  /* tail-recursive version */
  def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def loop(remaining: Int, reversed: Int): Int =
      if remaining == 0 then
        reversed
      else
        loop(remaining / 10, reversed * 10 + remaining % 10)
    loop(n, 0)

  // Task 8 ( Define a sum type Expr to represent arithmetic expressions), svolto con Thomas Testa

  /* Sum type */
  enum Expr:
    case Literal(value: Int)
    case Add(left: Expr, right: Expr)
    case Multiply(left: Expr, right: Expr)

  object ExprModule:

    // Recursively computes the numeric value of the expression
    def evaluate(expr: Expr): Int = expr match
      case Expr.Literal(value) =>
        value
      case Expr.Add(left, right) =>
        evaluate(left) + evaluate(right)
      case Expr.Multiply(left, right) =>
        evaluate(left) * evaluate(right)

    // Recursively builds a string representation of the expression
    def show(expr: Expr): String = expr match
      case Expr.Literal(value) =>
        value.toString
      case Expr.Add(left, right) =>
        "(" + show(left) + " + " + show(right) + ")"
      case Expr.Multiply(left, right) =>
        "(" + show(left) + " * " + show(right) + ")"

  // Task 9 (Look at tasks5.Optionals)
  // not done

  @main def testLab2(): Unit =

    println("\n----------------------------------------")
    println("--- Task 1 -----------------------------")
    println("----------------------------------------")
    println("### Test: println()")
    println("Hello, Scala")

    println("\n----------------------------------------")
    println("--- Task 2 -----------------------------")
    println("----------------------------------------")

    // settings
    val m1 = mult(3, 4)
    val m2 = curriedMult(3)(4)
    val m3 = curriedMult3(3)(4)(5)

    println("### Testing multiplication:")
    println("mult(-100, -2): " + mult(-100, -2)) // 200
    println("mult(3, 4): " + m1) // 12
    println("curriedMult(3)(4): " + m2) // 12
    println("curriedMult3(3)(4)(5): " + m3) // 60

    val multiplyBy3 = curriedMult(6)
    println("\n### Testing multiplyBy3")
    println("multiplyBy3 = curriedMult(6): " + multiplyBy3) // 18

    println("\n### Testing division:")
    println("div(3, 4): " + div(3, 4)) // 0.75
    println("curriedDiv(2.2)(8): " + curriedDiv(2.2)(8)) // 0.275
    println("curriedDiv(0)(8): " + curriedDiv(0)(8)) // 0
    println("curriedDiv(0)(0): " + curriedDiv(0)(0)) // NaN
    println("curriedDiv(3)(0): " + curriedDiv(3)(0)) // Infinity

    println("\n----------------------------------------")
    println("--- Task 3.a ---------------------------")
    println("----------------------------------------")

    // settings
    val negInt = -10
    val zero = 0
    val posInt = 5
    val noInt = 1.2

    println("### Testing function literal (like lambda) with match-case:")
    println(s"$negInt is ${positive(negInt)}")
    println(s"$zero is ${positive(zero)}")
    println(s"$posInt is ${positive(posInt)}")
    //println(s"$noInt is ${positive(noInt)}") // raises an exception

    println("\n### Testing function with match-case:")
    println(s"$negInt is ${checkNumber(negInt)}")
    println(s"$zero is ${checkNumber(zero)}")
    println(s"$posInt is ${checkNumber(posInt)}")

    println("\n----------------------------------------")
    println("--- Task 3.b ---------------------------")
    println("----------------------------------------")

    println("### Testing empty function:")
    println("empty(\"pippo\"): " + empty("pippo")) // false
    println("empty(\"\"): " + empty("")) // true

    println("\n### Testing function with match-case ")
    println("notEmpty(\"foo\"): " + notEmpty("foo")) // true
    println("notEmpty(\"\"): " + notEmpty("")) // false
    println(s"notEmpty(\"foo\") && !notEmpty(\"\"): ${notEmpty("foo") && !notEmpty("")}") // false

    println("\n----------------------------------------")
    println("--- Task 4 -----------------------------")
    println("----------------------------------------")

    println("### check 'x ≤ y = z' (val-curried)")
    println("p1(3)(3)(3): " + p1(3)(3)(3)) // true
    println("p1(2)(4)(3): " + p1(2)(4)(3)) // false
    println("p1(4)(3)(3): " + p1(4)(3)(3)) // false

    println("\n### check 'x ≤ y = z' val-not curried")
    println("p2(3,3,3): " + p2(3, 3, 3)) // true
    println("p2(2,4,3): " + p2(2, 4, 3)) // false
    println("p2(4,3,3): " + p2(4, 3, 3)) // false

    println("\n### check 'x ≤ y = z' def-curried")
    println("p3(3)(3)(3): " + p3(3)(3)(3)) // true
    println("p3(2)(4)(3): " + p3(2)(4)(3)) // false
    println("p3(4)(3)(3): " + p3(4)(3)(3)) // false

    println("\n### check 'x ≤ y = z' def-not curried")
    println("p4(3,3,3): " + p4(3, 3, 3)) // true
    println("p4(2,4,3): " + p4(2, 4, 3)) // false
    println("p4(4,3,3): " + p4(4, 3, 3)) // false

    println("\n----------------------------------------")
    println("--- Task 5 -----------------------------")
    println("----------------------------------------")

    // setting
    val res = compose(2, f, g) // 4 * (2 + 2) = 16

    println("### Testing function composition (f ◦ g)(x) = f(g(x)):")
    println("compose(2, f, g) -> \"4 * (2 + 2) = 16\": " + res)
    println("compose(2, _ * 4, _ + 2): " + compose(2, _ * 4, _ + 2)) // 16

    println("\n----------------------------------------")
    println("--- Task 6 -----------------------------")
    println("----------------------------------------")

    println("### Testing power(base, exponent):")
    println("power(2, 3): " + power(2, 3)) // 8.0
    println("power(2, 0): " + power(2, 0)) // 1.0

    println("\n### Testing powerTail:")
    println("powerTail(2, 3): " + powerTail(2, 3)) // 8.0
    println("powerTail(2, 0): " + powerTail(2, 0)) // 1.0

    println("\n----------------------------------------")
    println("--- Task 7 -----------------------------")
    println("----------------------------------------")

    println("### Testing reverseNumber(Int)")
    println("reverseNumber(25431): " + reverseNumber(25431))
    println("reverseNumber(25030): " + reverseNumber(25030))
    println("reverseNumber(05431): " + reverseNumber(05431))

    println("\n----------------------------------------")
    println("--- Task 8 -----------------------------")
    println("----------------------------------------")

    println("Run ExprTest in 'src/main/test/task5'")

}