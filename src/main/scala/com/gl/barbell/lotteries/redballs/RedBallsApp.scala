package com.gl.barbell.lotteries.redballs

import com.gl.barbell.core.{FalseRationality, NumberBasedLottery, Rule}
import com.gl.barbell.lotteries.UniqueRandomNumberLotteryShaker
import com.gl.barbell.presenters.ConsolePresenter
import com.gl.barbell.rules.{ContinuationRule, ParityRatioRule, SumScopeRule}

object RedBallsApp extends App {

  val redBallShaker = new UniqueRandomNumberLotteryShaker(6, 33)

  val rules = List[Rule](
    new SumScopeRule(60, 150),
    new ParityRatioRule(0.15),
    new ContinuationRule(3)
  )

  val falseRationality = new FalseRationality(rules)

  (1 to 5).map((i) => shakeOnce()).foreach(ConsolePresenter.present(_))

  def shakeOnce(): NumberBasedLottery = {
    val red = redBallShaker.shake()
    if (falseRationality.keep(red)) red else shakeOnce()
  }
}
