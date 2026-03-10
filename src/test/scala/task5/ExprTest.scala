package task5

import org.junit.Assert.*
import org.junit.Test
import it.unibo.pps.u02.Exercise8.*
import it.unibo.pps.u02.Exercise8.Expr.Literal

class ExprTest:
  @Test def testEvaluateLiteral(): Unit =
    val literal = 5
    val expr = Expr.Literal(literal)
    assertEquals(literal, evaluate(expr))

  @Test def testEvaluateSum(): Unit =
    val expectedSum = 5 + 10
    val expr1 = Expr.Literal(5)
    val expr2 = Expr.Literal(10)
    val sumExpr = Expr.Add(expr1, expr2)
    assertEquals(expectedSum, evaluate(sumExpr))

  @Test def testEvaluateMult(): Unit =
    val expectedMult = 5 * 10
    val expr1 = Expr.Literal(5)
    val expr2 = Expr.Literal(10)
    val multExpr = Expr.Multiply(expr1, expr2)
    assertEquals(expectedMult, evaluate(multExpr))

  @Test def testShow(): Unit =
    val expectedString = s"(( ${5} + ${10} ) * ( ${5} + ${10} ))"
    val expr1 = Expr.Literal(5)
    val expr2 = Expr.Literal(10)
    val sumExpr = Expr.Add(expr1, expr2)
    val multExpr = Expr.Multiply(sumExpr, sumExpr)
    assertEquals(expectedString, show(multExpr))



