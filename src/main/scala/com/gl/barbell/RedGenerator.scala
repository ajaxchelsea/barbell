package com.gl.barbell

class Red extends NumberBasedLottery {

  def add(number: Int) = {
    values + number
  }

  override def numbers: List[Int] = {
    values.toList
  }

  private
  val values: scala.collection.mutable.Set[Int] = scala.collection.mutable.Set[Int]()
}

class RedGenerator {

  def shake(): NumberBasedLottery = {
    new Red()
  }

}
