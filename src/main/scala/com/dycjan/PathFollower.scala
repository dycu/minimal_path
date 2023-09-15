package com.dycjan

import com.dycjan.domain.Step.{LeftStep, RightStep}
import com.dycjan.domain.{Step, Value}

/** Given the list of steps returns the path traversed
  */
class PathFollower {

  def findValues(
      path: List[Step],
      rows: List[List[Value]],
      x: Int,
      y: Int
  ): List[Value] = {
    path match {
      case Nil =>
        List(rows(x)(y))
      case step :: rest =>
        step match {
          case LeftStep =>
            List(rows(x)(y)) ++ findValues(rest, rows, x + 1, y)
          case RightStep =>
            List(rows(x)(y)) ++ findValues(
              rest,
              rows,
              x + 1,
              y + 1
            )
        }

    }
  }
}
