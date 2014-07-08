package com.gl.barbell.lotteries

import com.gl.barbell.core.NumberBasedLottery

class SetBasedLottery(val values: Set[Int]) extends NumberBasedLottery {
  override def numbers: List[Int] = {
    values.toList.sorted
  }
}
