package com.gl.barbell

import com.gl.barbell.Rules.Rule
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.prop.TableDrivenPropertyChecks._
import org.scalatest.{FunSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class FalseRationalitySpec extends FunSpec with Matchers {
  describe("test keep strategy") {

    it("should be kept only when satisfies all rules") {
      def alwaysTrue(lottery: NumberBasedLottery) = true
      def alwaysFalse(lottery: NumberBasedLottery) = false

      val data = Table[List[Rule], Boolean](
        ("rules", "should keep?"),
        (List(alwaysTrue, alwaysTrue), true),
        (List(alwaysTrue, alwaysFalse), false),
        (List(alwaysFalse, alwaysFalse), false)
      )

      forAll(data) { (rules, shouldKeep) =>
        new FalseRationality(rules).keep(new Red) should be(shouldKeep)
      }
    }

  }
}
