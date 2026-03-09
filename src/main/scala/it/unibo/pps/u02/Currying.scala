package it.unibo.pps.u02

object Currying extends App :

  // standard function with no currying
  def mult(x: Double, y: Double): Double = x * y

  // function with currying
  // curriedMult has actually type: Double => (Double => Double)
  def curriedMult(x: Double)(y: Double): Double = x * y

  // slightly different syntax at the call side..
  println(mult(10, 2)) // 20
  println(curriedMult(10)(2)) // 20

  // curriedMult can be partially applied!
  val twice: Double => Double = curriedMult(2)

  println(twice(10)) // 20

  // => is right-associative, hence it is equal to:
  //val curr...: Double => (Double => Double) = x => (y => x*y)
  val curriedMultAsFunction: Double => Double => Double = x => y => x * y

  println(curriedMultAsFunction(10)(2)) // 20
  println(curriedMultAsFunction) // u02.Currying$$$Lambda$7/...
  println(curriedMultAsFunction(10)) // u02.Currying$$$Lambda$12/...

  def divide(x: Double, y: Double) = (x, y) match
    case (_, 0) => "Error: division by 0"
    case _ => x / y

  def divideCurried(x: Double)(y: Double) = (x, y) match
    case (_, 0) => "Error: division by 0"
    case _ => x / y

  println(divide(3,4)) // 0.75
  println(divide(3,0)) // Error: division by 0
  println(divideCurried(3)(4)) // 0.75
  println(divideCurried(3)) //rs$line$44$$$Lambda$2257/0x0000025db26cc800@1eb4bd92
  println(divideCurried) //rs$line$45$$$Lambda$2260/0x0000025db26ccfc8@137d7b1f

  val half = (x: Double) => divideCurried(x)(2.0)

  println(half(4)) //2
  println(half) // rs$line$48$$$Lambda$2261/0x0000025db26cdf90@41b40d93

  val curriedDivAsFunction = (x: Double) => (y: Double) => (x, y) match
    case (_, 0) => "Error: division by 0"
    case _ => x / y

  println(curriedDivAsFunction(2)(3)) // 0.6666666666666666
  println(curriedDivAsFunction(2)(0)) // Error: division by 0
  println(curriedDivAsFunction(2)) // rs$line$51$$$Lambda$2263/0x0000025db26cf720@25d2921d
  println(curriedDivAsFunction) // rs$line$51$$$Lambda$2262/0x0000025db26cef58@30cce2bb



