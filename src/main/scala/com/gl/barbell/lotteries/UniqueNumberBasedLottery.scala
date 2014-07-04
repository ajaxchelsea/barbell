package com.gl.barbell.lotteries

import com.gl.barbell.core.NumberBasedLottery


class UniqueNumberBasedLottery extends NumberBasedLottery {

  def add(number: Int) = {
    values.add(number)
  }

  def contains(number: Int): Boolean = {
    values.contains(number)
  }

  override def numbers: List[Int] = {
    values.toList.sorted
  }

  private

  val values: scala.collection.mutable.Set[Int] = scala.collection.mutable.Set[Int]()
}

