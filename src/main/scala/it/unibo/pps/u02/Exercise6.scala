package it.unibo.pps.u02

import scala.annotation.tailrec

object Exercise6 extends App:

  def power(base: Double, exponent: Int): Double = exponent match
    case n if n < 0 => throw new ArithmeticException("Exponent cannot be negative")
    case _ =>
      @tailrec
      def recursivePower(n: Int, acc: Double): Double = n match
        case 0 | 1 => acc
        case _ => recursivePower(n - 1, base * acc)
      recursivePower(exponent, base)

  println(power(4, 3))



