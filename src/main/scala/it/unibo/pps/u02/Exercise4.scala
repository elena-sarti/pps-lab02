package it.unibo.pps.u02

object Exercise4 extends App:

  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z

  val p2: (Int, Int, Int) => Boolean = (x, y, z) => x <= y && y == z

  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z

  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

  val res = p1(1)(2)(2)
  println(res)
  val res1 = p1(1)(2)(3)
  println(res1)
  val res2 = p2(1,2,2)
  println(res2)
  val res3 = p3(8)(2)(2)
  println(res3)
  val res4 = p4(1,2,3)
  println(res4)