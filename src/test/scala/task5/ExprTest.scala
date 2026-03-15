package task5

import org.junit.*
import org.junit.Assert.*
import it.unibo.pps.u02.Lab2.*

class ExprTest:

  @Test
  def testLiteralEvaluate(): Unit =
    assertEquals(5, ExprModule.evaluate(Expr.Literal(5)))

  @Test
  def testAddEvaluate(): Unit =
    val expr = Expr.Add(Expr.Literal(2), Expr.Literal(3))
    assertEquals(5, ExprModule.evaluate(expr))

  @Test
  def testMultiplyEvaluate(): Unit =
    val expr = Expr.Multiply(Expr.Literal(2), Expr.Literal(4))
    assertEquals(8, ExprModule.evaluate(expr))

  @Test
  def testNestedEvaluate(): Unit =
    val expr = Expr.Multiply(
      Expr.Add(Expr.Literal(2), Expr.Literal(3)),
      Expr.Literal(4)
    )
    assertEquals(20, ExprModule.evaluate(expr))

  @Test
  def testShowLiteral(): Unit =
    assertEquals("5", ExprModule.show(Expr.Literal(5)))

  @Test
  def testShowAdd(): Unit =
    val expr = Expr.Add(Expr.Literal(2), Expr.Literal(3))
    assertEquals("(2 + 3)", ExprModule.show(expr))

  @Test
  def testShowMultiply(): Unit =
    val expr = Expr.Multiply(Expr.Literal(2), Expr.Literal(4))
    assertEquals("(2 * 4)", ExprModule.show(expr))

  @Test
  def testShowNested(): Unit =
    val expr = Expr.Multiply(
      Expr.Add(Expr.Literal(2), Expr.Literal(3)),
      Expr.Literal(4)
    )
    assertEquals("((2 + 3) * 4)", ExprModule.show(expr))