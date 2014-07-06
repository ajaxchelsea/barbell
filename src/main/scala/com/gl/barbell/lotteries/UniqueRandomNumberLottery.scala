package com.gl.barbell.lotteries

import com.gl.barbell.core.NumberBasedLottery

import scala.collection.mutable
import scala.util.Random

class UniqueRandomNumberLottery(val count: Int, val max: Int) extends NumberBasedLottery {

  private val lottery: List[Int] = shake

  private def shake(): List[Int] = {
    (1 to count)
      .foldLeft(mutable.Set[Int]())((values, i) => {values.add(shakeOnce(values)); values})
      .toList
      .sorted
  }

  private def shakeOnce(values: scala.collection.mutable.Set[Int]): Int = {
    val next = Random.nextInt(max) + 1
    if (values.contains(next)) shakeOnce(values) else next
  }

  override def numbers: List[Int] = {
    lottery
  }
}
