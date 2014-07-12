package com.gl.barbell.rules

import com.gl.barbell.lotteries.SetBasedLottery
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class MaxContinuationRuleSpec extends FunSpec with Matchers {
  describe("test continuation rule") {

    it("satisfied only when continuous numbers <= specified number") {

      val data = Table[Set[Int], Boolean](
        ("lotteries", "satisfied?"),
        (Set(1, 3, 4, 5, 6, 9), false),
        (Set(1, 2, 3, 7, 8, 9), true)
      )

      forAll(data) { (lottery, satisfied) =>
        new MaxContinuationRule(3).satisfied(new SetBasedLottery(lottery)) should be(satisfied)
      }
    }

  }

}
