package com.dycjan

import com.dycjan.domain.{Triangle, Value}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MinimalPathCalculatorSpec extends AnyWordSpec with Matchers {

  private val pathFollower = new PathFollower()
  val calculator = new MinimalPathCalculator(pathFollower)

  "Calculating minimal path" when {
    "there's only one element" should {
      "return this element" in {
        val triangle = Triangle(List(List(Value(1))))
        val path = List(Value(1))

        calculator.findMinimalPath(
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
        val path = List(Value(1), Value(1), Value(1))

        calculator.findMinimalPath(
          triangle
        ) shouldEqual path
      }
    }
  }

}
