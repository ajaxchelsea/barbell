package com.gl.barbell

import com.gl.barbell.core.NumberBasedLottery

package object rules {

  implicit class LotteryExtensions(set: Set[Int]) {
    def toLottery(): NumberBasedLottery = new SetBasedLottery(set)
  }

  class SetBasedLottery(val values: Set[Int]) extends NumberBasedLottery {
    override def numbers: List[Int] = {
      values.toList.sorted
    }
  }

}
