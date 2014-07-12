package com.gl.barbell.presenters

import com.gl.barbell.core.NumberBasedLottery

object TaobaoFormatter {

  def format(seq: Int, lottery: NumberBasedLottery): String = {
    lottery.numbers.map(_.formatted("%02d")).mkString(" ") + ":" + seq.formatted("%02d")
  }

}
