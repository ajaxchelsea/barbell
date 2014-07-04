package com.gl.barbell.lotteries.redballs

import com.gl.barbell.core.NumberBasedLottery
import com.gl.barbell.lotteries.UniqueNumberBasedLottery

import scala.util.Random

class RedBalls {

  def shake(): NumberBasedLottery = {
    (1 to 6).foldLeft(new UniqueNumberBasedLottery())((lottery, i) => lottery.add(shakeOnce(lottery)))
  }

  private

  def shakeOnce(lottery: UniqueNumberBasedLottery): Int = {
    val next = Random.nextInt(33) + 1
    if (lottery.contains(next)) shakeOnce(lottery) else next
  }
}
