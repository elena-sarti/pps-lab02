package it.unibo.pps.u02

object ExerciseREPL extends App:

  def divide(x: Double, y: Double): Double = (x, y) match
    case (_, 0) => throw new ArithmeticException("Error: division by 0")
    case _      => x / y

  def divideCurried(x: Double)(y: Double): Double = (x, y) match
    case (_, 0) => throw new ArithmeticException("Error: division by 0")
    case _      => x / y

  println(divide(3, 4)) // 0.75
  println(divide(3, 0)) // Error: division by 0
  println(divideCurried(3)(4)) // 0.75
  println(divideCurried(3)) //rs$line$44$$$Lambda$2257/0x0000025db26cc800@1eb4bd92
  println(divideCurried) //rs$line$45$$$Lambda$2260/0x0000025db26ccfc8@137d7b1f

  val half = (x: Double) => divideCurried(x)(2.0)

  println(half(4)) //2
  println(half) // rs$line$48$$$Lambda$2261/0x0000025db26cdf90@41b40d93

  val curriedDivAsFunction: Double => Double => Double = x => y => (x, y) match
    case (_, 0) => throw new ArithmeticException("Error: division by 0")
    case _      => x / y

  println(curriedDivAsFunction(2)(3)) // 0.6666666666666666
  println(curriedDivAsFunction(2)(0)) // Error: division by 0
  println(curriedDivAsFunction(2)) // rs$line$51$$$Lambda$2263/0x0000025db26cf720@25d2921d
  println(curriedDivAsFunction) // rs$line$51$$$Lambda$2262/0x0000025db26cef58@30cce2bb

