package com.gl.barbell.rules

import com.gl.barbell.core.{NumberBasedLottery, Rule}

class RangeRule(ranges: Map[Range, Int]) extends Rule {
  override def satisfied(lottery: NumberBasedLottery): Boolean = {
    ranges.forall((pair) => lottery.numbers.count(pair._1.contains(_)) >= pair._2)
  }
}
