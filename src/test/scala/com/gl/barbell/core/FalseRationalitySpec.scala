package com.gl.barbell.core

import com.gl.barbell.lotteries.SetBasedLottery
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class FalseRationalitySpec extends FunSpec with Matchers {
  describe("test keep strategy") {

    it("should be kept only when satisfies all rules") {

      object alwaysTrue extends Rule {
        override def satisfied(lottery: NumberBasedLottery): Boolean = true
      }
      object alwaysFalse extends Rule {
        override def satisfied(lottery: NumberBasedLottery): Boolean = false
      }

      val data = Table[List[Rule], Boolean](
        ("rules", "should keep?"),
        (List(alwaysTrue, alwaysTrue), true),
        (List(alwaysTrue, alwaysFalse), false),
        (List(alwaysFalse, alwaysFalse), false)
      )

      forAll(data) { (rules, shouldKeep) =>
        new FalseRationality(rules).keep(new SetBasedLottery(Set())) should be(shouldKeep)
      }
    }

  }
}
