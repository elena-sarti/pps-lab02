package it.unibo.pps.u02

object Exercise6 extends App:

  def power(base: Double, exponent: Int) = exponent match
    case n if n < 0 => "Error: exponent should be positive"
    case _ =>
      def recursivePower(n: Int, acc: Double): Double = n match
        case 0 | 1 => acc
        case _ => recursivePower(n - 1, base * acc)
      recursivePower(exponent, base)

  println(power(3,4))