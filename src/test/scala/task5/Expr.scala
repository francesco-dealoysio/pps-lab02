package task5


// Sum type
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

/* per esempio rapido
@main def testExpr(): Unit =
  val expr1 = Expr.Add(Expr.Literal(2), Expr.Literal(3))
  val expr2 = Expr.Multiply(expr1, Expr.Literal(4))

  println(ExprModule.evaluate(expr1)) // 5
  println(ExprModule.show(expr1))     // (2 + 3)

  println(ExprModule.evaluate(expr2)) // 20
  println(ExprModule.show(expr2))     // ((2 + 3) * 4)
  */
