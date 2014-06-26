package com.gl.barbell

import com.gl.barbell.Rules.Rule

class FalseRationality(rules: List[Rule], lottery: NumberBasedLottery) {
  def keep(): Boolean = rules.forall(_(lottery))
}
