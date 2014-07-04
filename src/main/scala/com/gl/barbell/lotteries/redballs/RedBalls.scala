package com.gl.barbell.lotteries.redballs

import com.gl.barbell.core.NumberBasedLottery
import com.gl.barbell.lotteries.UniqueNumberBasedLottery

import scala.util.Random

class RedBalls {
  val red = new UniqueNumberBasedLottery()
  (1 to 6).foreach((i) => red.add(shakeOnce()))

  def shake(): NumberBasedLottery = {
    red
  }

  private

  def shakeOnce(): Int = {
    val next = Random.nextInt(33) + 1
    if (red.contains(next)) shakeOnce() else next
  }
}
