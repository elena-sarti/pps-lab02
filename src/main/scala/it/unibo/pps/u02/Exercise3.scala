package it.unibo.pps.u02

object Exercise3 extends App:

  val sign: Int => String = _ match
    case n if n >= 0 => "positive"
    case _ => "negative"

  def sign2(x: Int): String = x match
    case n if n >= 0 => "positive"
    case _ => "negative"

  val neg: (String => Boolean) => String => Boolean = f => a => f(a) match
    case n if n => false
    case _ => true

  val empty: String => Boolean = _ == "" // predicate on strings
  val notEmpty = neg(empty) // which type of notEmpty?
  println(notEmpty("foo"))// true
  println(notEmpty("")) // false
  println(notEmpty("foo") && !notEmpty(""))

  def neg2(f: String => Boolean)(a: String): Boolean = f(a) match
    case n if n => false
    case _ => true

  val empty1: String => Boolean = _ == "" // predicate on strings
  val notEmpty1 = neg2(empty) // which type of notEmpty?
  println(notEmpty1("foo")) // true
  println(notEmpty1("")) // false
  println(notEmpty1("foo") && !notEmpty1(""))


