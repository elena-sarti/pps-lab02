package it.unibo.pps.u02

object Exercise5 extends App:

  def compose(f: Int => Int, g: Int => Int)(x: Int): Int = f(g(x))

  println(compose(_ - 3, _ * 4)(5))