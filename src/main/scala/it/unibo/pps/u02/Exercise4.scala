package it.unibo.pps.u02

object Exercise4 extends App:
  val p1: Int => Int => Int => Boolean = x => y => z => (x, y, z) match
    case (a, b, c) if a <= b && b == c => true
    case _ => false

  val p2: (Int, Int, Int) => Boolean = (_, _, _) match
    case (a, b, c) if a <= b && b == c => true
    case _ => false

  def p3(x: Int)(y: Int)(z: Int): Boolean = (x, y, z) match
    case (a, b, c) if a <= b && b == c => true
    case _ => false

  def p4(x: Int, y: Int, z: Int): Boolean = (x, y, z) match
    case (a, b, c) if a <= b && b == c => true
    case _ => false

  val res=p1(1)(2)(2)
  println(res)
  val res1 = p1(1)(2)(3)
  println(res1)
  val res2 = p2(1,2,2)
  println(res2)
  val res3 = p3(1)(2)(2)
  println(res3)
  val res4 = p4(1,2,2)
  println(res)