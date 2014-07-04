package com.gl.barbell

import com.gl.barbell.core.NumberBasedLottery

package object lotteries {

  implicit class SetExtensions(set: Set[Int]) {
    def toLottery(): NumberBasedLottery = {
      val lottery = new UniqueNumberBasedLottery
      set.foreach(lottery.add(_))
      lottery
    }
  }

}
