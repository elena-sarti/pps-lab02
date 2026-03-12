package it.unibo.pps.u02

import scala.annotation.tailrec

object Lab2 extends App:

  // Task 1, svolto da sola
  object HelloScala extends App:

    @main
    def main(): Unit =
      println("Hello, Scala")

  object ExerciseREPL extends App:

    def divide(x: Double, y: Double): Double = (x, y) match
      case (_, 0) => throw new ArithmeticException("Error: division by 0")
      case _      => x / y

    def divideCurried(x: Double)(y: Double): Double = (x, y) match
      case (_, 0) => throw new ArithmeticException("Error: division by 0")
      case _      => x / y

    val half = (x: Double) => divideCurried(x)(2.0)

    val curriedDivAsFunction: Double => Double => Double = x => y => (x, y) match
      case (_, 0) => throw new ArithmeticException("Error: division by 0")
      case _      => x / y

    @main def tryREPL(): Unit =
      println(divide(3, 4)) // 0.75
      println(divide(3, 0)) // Error: division by 0
      println(divideCurried(3)(4)) // 0.75
      println(divideCurried(3)) //rs$line$44$$$Lambda$2257/0x0000025db26cc800@1eb4bd92
      println(divideCurried) //rs$line$45$$$Lambda$2260/0x0000025db26ccfc8@137d7b1f
      println(half(4)) //2
      println(half) // rs$line$48$$$Lambda$2261/0x0000025db26cdf90@41b40d93
      println(curriedDivAsFunction(2)(3)) // 0.6666666666666666
      println(curriedDivAsFunction(2)(0)) // Error: division by 0
      println(curriedDivAsFunction(2)) // rs$line$51$$$Lambda$2263/0x0000025db26cf720@25d2921d
      println(curriedDivAsFunction) // rs$line$51$$$Lambda$2262/0x0000025db26cef58@30cce2bb

  //Task 2, svolto da sola
  object Exercise3 extends App:

    val sign: Int => String = _ match
      case n if n >= 0 => "positive"
      case _           => "negative"

    def sign2(x: Int): String = x match
      case n if n >= 0 => "positive"
      case _           => "negative"

    val neg: (String => Boolean) => String => Boolean = f => a => f(a) match
      case true => false
      case _    => true

    def neg2(f: String => Boolean)(a: String): Boolean = f(a) match
      case true => false
      case _    => true

    @main def tryNeg(): Unit =
      val empty: String => Boolean = _ == "" // predicate on strings
      val notEmpty = neg(empty) // which type of notEmpty?
      println(notEmpty("foo")) // true
      println(notEmpty("")) // false
      println(notEmpty("foo") && !notEmpty("")) //true
      val empty1: String => Boolean = _ == "" // predicate on strings
      val notEmpty1 = neg2(empty) // which type of notEmpty?
      println(notEmpty1("foo")) // true
      println(notEmpty1("")) // false
      println(notEmpty1("foo") && !notEmpty1("")) //true

  object Exercise4 extends App:

    val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
    val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z
    def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
    def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

    @main def tryCurrying(): Unit =
      val res = p1(1)(2)(2)
      println(res) //true
      val res1 = p1(1)(2)(3)
      println(res1) //false
      val res2 = p2(1, 2, 2)
      println(res2) //true
      val res3 = p3(8)(2)(2)
      println(res3) //false
      val res4 = p4(1, 2, 3)
      println(res4) //false

  object Exercise5 extends App:

    def compose(f: Int => Int, g: Int => Int)(x: Int): Int = f(g(x))

  //Task 3, svolto da sola
  def power(base: Double, exponent: Int): Double = exponent match
    case n if n < 0 => throw new ArithmeticException("Exponent cannot be negative")
    case _          =>
      @tailrec
      def recursivePower(n: Int, acc: Double): Double = n match
        case 0 | 1 => acc
        case _     => recursivePower(n - 1, base * acc)
      recursivePower(exponent, base)

  def reverseNumber(n: Int): Int =
    @tailrec
    def _reverse(n: Int, acc: Int): Int = n match
      case 0 => acc
      case _ =>
        val numYetToBeReversed = n / 10
        val numAlreadyReversed = acc * 10
        val modDivByTen = n % 10
        _reverse(numYetToBeReversed, numAlreadyReversed + modDivByTen)
    _reverse(n, 0)

  //Task 4, svolto da sola
  object Exercise8 extends App:

    enum Expr:
      case Literal(numericConstant: Int)
      case Add(expr1: Expr, expr2: Expr)
      case Multiply(expr1: Expr, expr2: Expr)

    object Expr:

      def evaluate(expr: Expr): Int = expr match
        case Expr.Literal(numericConstant) => numericConstant
        case Expr.Add(expr1, expr2)        => evaluate(expr1) + evaluate(expr2)
        case Expr.Multiply(expr1, expr2)   => evaluate(expr1) * evaluate(expr2)

      def show(expr: Expr): String = expr match
        case Expr.Literal(numericConstant) => s"${evaluate(Expr.Literal(numericConstant))}"
        case Expr.Add(expr1, expr2)        => "( " + show(expr1) + " + " + show(expr2) + " )"
        case Expr.Multiply(expr1, expr2)   => "( " + show(expr1) + " * " + show(expr2) + " )"

  //Task 5
  object Optionals:

    // type "public" definition, exposing structure
    enum OptionalInt:
      case Just(value: Int)
      case Empty()

    // operations (/algorithms)
    object OptionalInt:

      def isEmpty(opt: OptionalInt): Boolean = opt match
        case Empty() => true
        case _       => false

      def orElse(opt: OptionalInt, orElse: Int): Int = opt match
        case Just(a) => a
        case _       => orElse

      def mapInt(opt: OptionalInt)(f: Int => Int): OptionalInt = opt match
        case Just(a) => Just(f(a))
        case _       => Empty()

      def filter(opt: OptionalInt)(f: Int => Boolean): OptionalInt = opt match
        case Just(a) if f(a) => Just(a)
        case _               => Empty()
