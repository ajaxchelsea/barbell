package com.gl.barbell

object Barbell extends App {
  val rules = List[Rules.Rule](new SumScopeRule(50, 150).satisfied)
  val falseRationality = new FalseRationality(rules)
  (1 to 5).map((i) => shakeOnce()).foreach(ConsolePresenter.present(_))

  def shakeOnce(): NumberBasedLottery = {
    val generator = new RedGenerator()
    val red = generator.shake()
    if (falseRationality.keep(red)) red else shakeOnce()
  }
}
