package com.gl.barbell.rules

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class SumScopeRuleSpec extends FunSpec with Matchers {
  describe("test sum scope rule") {

    it("satisfied only when min <= sum <= max") {

      val data = Table[Set[Int], Boolean](
        ("lotteries", "satisfied?"),
        (Set(1, 2, 3), false),
        (Set(10, 20, 30), false),
        (Set(4, 5, 6), true),
        (Set(7, 8, 9), true),
        (Set(10, 11, 12), true)
      )

      forAll(data) { (lottery, satisfied) =>
        new SumScopeRule(4 + 5 + 6, 10 + 11 + 12).satisfied(lottery.toLottery) should be(satisfied)
      }
    }

  }

}
