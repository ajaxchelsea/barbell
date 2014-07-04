package com.gl.barbell.core

trait Rule {
  def satisfied(lottery: NumberBasedLottery): Boolean
}
