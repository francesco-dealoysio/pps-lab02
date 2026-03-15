package it.unibo.pps.u02

object CurryingExercises:

  // p1: curried function stored in a val
  val p1: Int => Int => Int => Boolean =
    x => y => z =>
      x < y && y <= z


  // p2: non-curried function stored in a val
  val p2: (Int, Int, Int) => Boolean =
    (x, y, z) =>
      x < y && y <= z


  // p3: curried method (multiple parameter lists)
  def p3(x: Int)(y: Int)(z: Int): Boolean =
    x < y && y <= z


  // p4: normal method (all parameters together)
  def p4(x: Int, y: Int, z: Int): Boolean =
    x < y && y <= z



// Simple tests
@main def testCurrying(): Unit =
  println("Testing p1 (curried val)")
  println(CurryingExercises.p1(1)(2)(3))
  println(CurryingExercises.p1(3)(2)(1))

  println("Testing p2 (non-curried val)")
  println(CurryingExercises.p2(1,2,3))
  println(CurryingExercises.p2(3,2,1))

  println("Testing p3 (curried def)")
  println(CurryingExercises.p3(1)(2)(3))

  println("Testing p4 (normal def)")
  println(CurryingExercises.p4(1,2,3))