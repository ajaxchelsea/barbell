package com.gl.barbell.rules

import com.gl.barbell.lotteries.SetBasedLottery
import org.junit.runner.RunWith
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.prop.Tables.Table
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class RangeRuleSpec extends FunSpec with Matchers {
  describe("test range rule") {

    it("satisfied only when covered all ranges") {

      val data = Table[Set[Int], Boolean](
        ("lotteries", "satisfied?"),
        (Set(1, 12, 23), true),
        (Set(11, 22, 33), true),
        (Set(12, 24, 30), false),
        (Set(5, 15, 20), false),
        (Set(5, 25, 30), false)
      )

      forAll(data) { (lottery, satisfied) =>
        new RangeRule(Map((1 to 11, 1), ((12 to 22), 1), ((23 to 33), 1))).satisfied(new SetBasedLottery(lottery)) should be(satisfied)
      }
    }

  }

}
