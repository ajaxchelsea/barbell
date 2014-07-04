package com.gl.barbell.rules

import com.gl.barbell.core.{NumberBasedLottery, Rule}

class SumScopeRule(min: Int, max: Int) extends Rule {
  def satisfied(lottery: NumberBasedLottery): Boolean = {
    min <= lottery.numbers.sum && lottery.numbers.sum <= max
  }
}
