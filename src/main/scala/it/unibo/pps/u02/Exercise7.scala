package it.unibo.pps.u02

import Exercise6.*

import scala.annotation.tailrec

object Exercise7 extends App:

  def reverseNumber(n: Int): Int =
    @tailrec
    def _reverse(n: Int, acc: Int): Int = n match
      case 0 => acc
      case _ =>
        val numToBeReversed = n / 10
        val numAlreadyReversed = acc * 10
        val modDivByTen = n % 10
        _reverse(numToBeReversed, numAlreadyReversed + modDivByTen)
    _reverse(n, 0)

  val res = reverseNumber(12345)
  println(res)
