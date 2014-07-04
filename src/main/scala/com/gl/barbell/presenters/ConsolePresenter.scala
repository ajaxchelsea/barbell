package com.gl.barbell.presenters

import com.gl.barbell.core.NumberBasedLottery

object ConsolePresenter {

  def present(lottery: NumberBasedLottery) = {
    println(lottery.numbers.mkString(","))
  }

}
