package com.dycjan

import com.dycjan.domain.Step.{LeftStep, RightStep}
import com.dycjan.domain.{Step, Value}

/** Given the list of steps returns the path traversed
  */
class PathFollower {

  def findValues(
      path: List[Step],
      rows: List[List[Value]],
      y: Int
  ): List[Value] = {
    path match {
      case Nil =>
        List(rows.head(y))
      case step :: rest =>
        step match {
          case LeftStep =>
            List(rows.head(y)) ++ findValues(rest, rows.tail, y)
          case RightStep =>
            List(rows.head(y)) ++ findValues(
              rest,
              rows.tail,
              y + 1
            )
        }

    }
  }
}
