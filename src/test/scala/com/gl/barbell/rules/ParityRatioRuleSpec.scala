package com.gl.barbell.rules

import com.gl.barbell.lotteries.SetBasedLottery
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class ParityRatioRuleSpec extends FunSpec with Matchers {
  describe("test parity ratio rule") {

    it("satisfied only when parity ratio >= specified percentage") {

      val data = Table[Set[Int], Boolean](
        ("lotteries", "satisfied?"),
        (Set(10, 20, 30, 40, 50, 60), false),
        (Set(11, 21, 31, 41, 51, 61), false),
        (Set(1, 3, 5, 7, 9, 2), false),
        (Set(2, 4, 6, 8, 10, 1), false),
        (Set(2, 4, 6, 8, 1, 3), true),
        (Set(1, 3, 5, 7, 2, 4), true),
        (Set(1, 2, 3, 4, 5, 6), true)
      )

      forAll(data) { (lottery, satisfied) =>
        new ParityRatioRule(0.3).satisfied(new SetBasedLottery(lottery)) should be(satisfied)
      }
    }

  }

}
