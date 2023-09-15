package com.dycjan

import com.dycjan.Step.{LeftStep, RightStep}
import com.dycjan.domain.{Path, Triangle, Value}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MinimalPathCalculatorSpec extends AnyWordSpec with Matchers {

  val calculator = new MinimalPathCalculator

  "Calculating minimal path" when {
    "there's only one element" should {
      "return this element" in {
        val triangle = Triangle(List(List(Value(1))))
        val path = Path(List.empty)

        calculator.calculateMinimalPath(
          triangle
        ) shouldEqual path
      }
    }

    "there are two rows with one proper path always left" should {
      "return this path" in {
        val triangle = Triangle(
          List(
            List(Value(1)),
            List(Value(1), Value(2)),
            List(Value(2), Value(1), Value(3))
          )
        )
        val path = Path(List(LeftStep, RightStep))

        calculator.calculateMinimalPath(
          triangle
        ) shouldEqual path
      }
    }
  }

  "Finding values" should {
    "follow the path" in {
      val triangle = Triangle(
        List(
          List(Value(1)),
          List(Value(1), Value(2)),
          List(Value(2), Value(1), Value(3))
        )
      )
      val path = Path(List(LeftStep, RightStep))

      calculator.findValues(
        path.steps,
        triangle.values,
        0,
        0
      ) shouldEqual List(Value(1), Value(1), Value(1))
    }
  }

//  "Pairing values" should {
//    "return proper pairs" in {
//      calculator.pairValues(
//        List(
//          Min(Value(1), Path(List.empty)),
//          Min(Value(2), Path(List.empty)),
//          Min(Value(3), Path(List.empty))
//        )
//      ) shouldEqual List(Pair(Value(1), Value(2)), Pair(Value(2), Value(3)))
//    }
//  }

}
