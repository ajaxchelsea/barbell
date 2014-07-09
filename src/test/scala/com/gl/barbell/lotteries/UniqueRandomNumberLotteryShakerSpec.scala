package com.gl.barbell.lotteries

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class UniqueRandomNumberLotteryShakerSpec extends FunSpec with Matchers {
  describe("test unique random shaker") {

    val shaker = new UniqueRandomNumberLotteryShaker(6, 50)
    val results = (1 to 100).map((i) => shaker.shake().numbers.toSet)

    it("should not contain duplicated numbers") {
      results.forall(_.size == 6)
    }

    it("should not contain numbers out of range") {
      results.forall(_.max <= 50)
      results.forall(_.min >= 1)
    }
  }
}
