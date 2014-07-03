package com.gl.barbell

object Rules {
  type Rule = NumberBasedLottery => Boolean
}

class SumScopeRule(min: Int, max: Int) {
  def satisfied(lottery: NumberBasedLottery) : Boolean = {
    true
  }
}