package com.gl.barbell.rules

import com.gl.barbell.core.{NumberBasedLottery, Rule}

class ExclusiveRule(excludedNumbers: Set[Int]) extends Rule {
  override def satisfied(lottery: NumberBasedLottery): Boolean = {
    lottery.numbers.intersect(excludedNumbers.toList).size == 0
  }
}
