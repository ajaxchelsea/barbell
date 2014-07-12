package com.gl.barbell.lotteries.redballs

import com.gl.barbell.core.{FalseRationality, NumberBasedLottery, Rule}
import com.gl.barbell.lotteries.UniqueRandomNumberLotteryShaker
import com.gl.barbell.presenters.ConsolePresenter
import com.gl.barbell.rules._

object RedBallsApp extends App {

  val redBallShaker = new UniqueRandomNumberLotteryShaker(6, 33)

  val rules = List[Rule](
    new SumScopeRule(60, 150),
    new ParityRatioRule(0.15),
    new ContinuationRule(3),
    new RangeRule(Map((1 to 11, 1), ((12 to 22), 1), ((23 to 33), 1))),
    new ExclusiveRule(Set(2, 3, 5, 6, 9, 17))
  )

  val falseRationality = new FalseRationality(rules)

  (1 to 16).foreach((i) => ConsolePresenter.present(shakeOnce()))

  def shakeOnce(): NumberBasedLottery = {
    val red = redBallShaker.shake()
    if (falseRationality.keep(red)) red else shakeOnce()
  }
}
