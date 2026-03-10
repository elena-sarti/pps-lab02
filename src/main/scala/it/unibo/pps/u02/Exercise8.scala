package it.unibo.pps.u02

import it.unibo.pps.u02.Exercise8.Expr.{Add, Literal, Multiply}

object Exercise8 extends App:

  enum Expr:

    case Literal(numericConstant: Int)
    case Add(expr1: Expr, expr2: Expr)
    case Multiply(expr1: Expr, expr2: Expr)

  object Expr:

    def evaluate(expr: Expr): Int = expr match
      case Expr.Literal(numericConstant) => numericConstant
      case Expr.Add(expr1, expr2) => evaluate(expr1) + evaluate(expr2)
      case Expr.Multiply(expr1, expr2) => evaluate(expr1) * evaluate(expr2)

    def show(expr: Expr): String = expr match
      case Expr.Literal(numericConstant) => s"${evaluate(Expr.Literal(numericConstant))}"
      case Expr.Add(expr1, expr2) => "(" + show(expr1) + " + " + show(expr2) + ")"
      case Expr.Multiply(expr1, expr2) =>  "(" + show(expr1) + " * " + show(expr2) + ")"
