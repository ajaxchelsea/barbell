package com.gl.barbell.lotteries

import com.gl.barbell.core.NumberBasedLottery

import scala.collection.mutable
import scala.util.Random

class UniqueRandomNumberLotteryShaker(val count: Int, val max: Int) {

  def shake(): NumberBasedLottery = {
    val values = (1 to count)
      .foldLeft(mutable.Set[Int]())((values, i) => { values.add(shakeOnce(values)); values})
      .toSet
    new SetBasedLottery(values)
  }

  private def shakeOnce(values: scala.collection.mutable.Set[Int]): Int = {
    val next = Random.nextInt(max) + 1
    if (values.contains(next)) shakeOnce(values) else next
  }

}
