package com.gl.barbell

import scala.util.Random

class Red extends NumberBasedLottery {

  def add(number: Int) = {
    values.add(number)
  }

  def contains(number: Int): Boolean = {
    values.contains(number)
  }

  override def numbers: List[Int] = {
    values.toList.sorted
  }

  private

  val values: scala.collection.mutable.Set[Int] = scala.collection.mutable.Set[Int]()
}

class RedGenerator {
  val red = new Red()
  (1 to 6).foreach((i) => red.add(shakeOnce()))

  def shake(): NumberBasedLottery = {
    red
  }

  private

  def shakeOnce(): Int = {
    val next = Random.nextInt(33) + 1
    if (red.contains(next)) shakeOnce() else next
  }

}
