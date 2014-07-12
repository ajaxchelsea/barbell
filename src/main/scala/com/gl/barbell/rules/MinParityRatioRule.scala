package com.gl.barbell.rules

import com.gl.barbell.core.{NumberBasedLottery, Rule}

class MinParityRatioRule(percentage: Double) extends Rule {
  override def satisfied(lottery: NumberBasedLottery): Boolean = {
    val countOfEven = lottery.numbers.count( _ % 2 == 0).toDouble
    val ratio = countOfEven / lottery.numbers.size
    ratio >= percentage && ratio <= (1 - percentage)
  }
}
