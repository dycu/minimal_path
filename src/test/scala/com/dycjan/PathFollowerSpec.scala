package com.dycjan

import com.dycjan.domain.Step.{LeftStep, RightStep}
import com.dycjan.domain.{Path, Triangle, Value}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PathFollowerSpec extends AnyWordSpec with Matchers {

  val pathFollower = new PathFollower()

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

      pathFollower.findValues(
        path.steps,
        triangle.values,
        0
      ) shouldEqual List(Value(1), Value(1), Value(1))
    }
  }

}
