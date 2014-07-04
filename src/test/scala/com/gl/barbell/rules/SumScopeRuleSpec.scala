package com.gl.barbell.rules

import com.gl.barbell.core.NumberBasedLottery
import com.gl.barbell.lotteries.SetExtensions
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class SumScopeRuleSpec extends FunSpec with Matchers {
  describe("test sum scope rule") {

    it("satisfied only when min <= sum <= max") {

      val data = Table[NumberBasedLottery, Boolean](
        ("lotteries", "satisfied?"),
        (Set(1, 2, 3).toLottery, false),
        (Set(10, 20, 30).toLottery, false),
        (Set(4, 5, 6).toLottery, true),
        (Set(7, 8, 9).toLottery, true),
        (Set(10, 11, 12).toLottery, true)
      )

      forAll(data) { (lottery, satisfied) =>
        new SumScopeRule(4 + 5 + 6, 10 + 11 + 12).satisfied(lottery) should be(satisfied)
      }
    }

  }

}
