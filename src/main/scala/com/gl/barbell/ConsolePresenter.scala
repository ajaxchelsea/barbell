package com.gl.barbell

object ConsolePresenter {

  def present(lottery: NumberBasedLottery) = {
    println(lottery.numbers.mkString(","))
  }

}
