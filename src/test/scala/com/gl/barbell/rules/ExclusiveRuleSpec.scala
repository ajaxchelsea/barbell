package com.gl.barbell.rules

import com.gl.barbell.lotteries.SetBasedLottery
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class ExclusiveRuleSpec extends FunSpec with Matchers {
  describe("test exclusive rule") {

    it("satisfied only when contains none of the specified numbers by default") {

      val data = Table[Set[Int], Boolean](
        ("lotteries", "satisfied?"),
        (Set(1, 3, 4, 9), false),
        (Set(1, 5, 6, 9), false),
        (Set(1, 8, 6, 9), false),
        (Set(1, 4, 6, 9), true)
      )

      forAll(data) { (lottery, satisfied) =>
        new ExclusiveRule(Set(3, 5, 8)).satisfied(new SetBasedLottery(lottery)) should be(satisfied)
      }
    }

    it("satisfied only when contains specified numbers not greater than max intersection count") {

      val data = Table[Set[Int], Boolean](
        ("lotteries", "satisfied?"),
        (Set(1, 3, 4, 9), true),
        (Set(1, 5, 6, 9), true),
        (Set(1, 8, 6, 9), true),
        (Set(1, 4, 6, 9), true),
        (Set(1, 3, 5, 9), false)
      )

      forAll(data) { (lottery, satisfied) =>
        new ExclusiveRule(Set(3, 5, 8), 1).satisfied(new SetBasedLottery(lottery)) should be(satisfied)
      }
    }
  }

}
