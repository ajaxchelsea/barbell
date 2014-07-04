package com.gl.barbell.core

class FalseRationality(rules: List[Rule]) {
  def keep(lottery: NumberBasedLottery): Boolean = rules.forall(_.satisfied(lottery))
}
