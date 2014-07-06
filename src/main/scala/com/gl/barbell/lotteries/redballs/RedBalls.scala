package com.gl.barbell.lotteries.redballs

import com.gl.barbell.core.NumberBasedLottery
import com.gl.barbell.lotteries.UniqueRandomNumberLottery

class RedBalls {
  def shake(): NumberBasedLottery = {
    new UniqueRandomNumberLottery(6, 33)
  }
}
