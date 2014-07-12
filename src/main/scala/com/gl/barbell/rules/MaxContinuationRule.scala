package com.gl.barbell.rules

import com.gl.barbell.core.{NumberBasedLottery, Rule}

class MaxContinuationRule(maxLength: Int) extends Rule {

  class Recorder {
    var current: Int = -1
    var paces: List[Int] = Nil

    def next(number: Int) = {
      paces = paces :+ (number - current)
      current = number
      this
    }

    def contains(slice: List[Int]) = paces.containsSlice(slice)
  }

  override def satisfied(lottery: NumberBasedLottery): Boolean = {
    val paces: Recorder = lottery.numbers.foldLeft(new Recorder)((r, i) => r.next(i))
    !paces.contains(List.fill(maxLength)(1))
  }
}
