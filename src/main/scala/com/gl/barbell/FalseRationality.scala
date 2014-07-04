package com.gl.barbell

import com.gl.barbell.Rules.Rule

class FalseRationality(rules: List[Rule]) {
  def keep(lottery: NumberBasedLottery): Boolean = rules.forall(_(lottery))
}
