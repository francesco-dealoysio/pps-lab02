package it.unibo.pps.u02

object Recursion:

  // Exercise 7
  // Recursive power function
  def power(base: Double, exponent: Int): Double =
    if exponent == 0 then
      1.0
    else
      base * power(base, exponent - 1)

  // Tail-recursive version of power
  def powerTail(base: Double, exponent: Int): Double =
    @annotation.tailrec
    def loop(exp: Int, acc: Double): Double =
      if exp == 0 then
        acc
      else
        loop(exp - 1, acc * base)

    loop(exponent, 1.0)

  // Exercise 8
  // Reverse the digits of a number using tail recursion
  def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def loop(remaining: Int, reversed: Int): Int =
      if remaining == 0 then
        reversed
      else
        loop(remaining / 10, reversed * 10 + remaining % 10)

    loop(n, 0)


// Simple main to test the functions
@main def testRecursion(): Unit =
  println("Testing power:")
  println(Recursion.power(2, 3))     // 8.0
  println(Recursion.power(5, 2))     // 25.0

  println("Testing powerTail:")
  println(Recursion.powerTail(2, 3)) // 8.0

  println("Testing reverseNumber:")
  println(Recursion.reverseNumber(12345)) // 54321