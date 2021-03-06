package com.gl.barbell.lotteries.redballs

import com.gl.barbell.core.{FalseRationality, NumberBasedLottery, Rule}
import com.gl.barbell.lotteries.UniqueRandomNumberLotteryShaker
import com.gl.barbell.presenters.{ConsolePresenter, FilePresenter, TaobaoFormatter}
import com.gl.barbell.rules._

object RedBallsApp extends App {

  val redBallShaker = new UniqueRandomNumberLotteryShaker(6, 33)

  val falseRationality = new FalseRationality(rules)

  val presenter = new FilePresenter("lottery.txt")

  val lotteries = (1 to 16).map((i) => shakeOnce())

  lotteries.indices.foreach((i) => presenter.present(TaobaoFormatter.format(i + 1, lotteries(i))))
  lotteries.indices.foreach((i) => ConsolePresenter.present(TaobaoFormatter.format(i + 1, lotteries(i))))

  def shakeOnce(): NumberBasedLottery = {
    val red = redBallShaker.shake()
    if (falseRationality.keep(red)) red else shakeOnce()
  }

  def rules: List[Rule] = List[Rule](
    new SumScopeRule(60, 150),
    new MinParityRatioRule(0.15),
    new MaxContinuationRule(3),
    new RangeRule(Map((1 to 11, 1), ((12 to 22), 1), ((23 to 33), 1))),
    new ExclusiveRule(Set(1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31), 4),
    new ExclusiveRule(Set(2, 7, 16, 22, 27, 28), 1)
  )
}
