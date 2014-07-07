package com.gl.barbell.lotteries.redballs

import com.gl.barbell.core.{FalseRationality, NumberBasedLottery, Rule}
import com.gl.barbell.presenters.ConsolePresenter
import com.gl.barbell.rules.{ParityRatioRule, SumScopeRule}

object RedBallsApp extends App {
  val rules = List[Rule](
    new SumScopeRule(60, 150),
    new ParityRatioRule(0.15)
  )
  val falseRationality = new FalseRationality(rules)
  (1 to 5).map((i) => shakeOnce()).foreach(ConsolePresenter.present(_))

  def shakeOnce(): NumberBasedLottery = {
    val red = new RedBalls().shake()
    if (falseRationality.keep(red)) red else shakeOnce()
  }
}
