package com.dycjan

import com.dycjan.domain.Step.{LeftStep, RightStep}
import com.dycjan.domain.{Step, Value}

/** Given the list of steps returns the path traversed
  */
class PathFollower {

  def findValues(
      path: List[Step],
      rows: List[List[Value]],
      rowNumber: Int
  ): List[Value] = {
    path match {
      case Nil =>
        List(rows.head(rowNumber))
      case step :: rest =>
        step match {
          case LeftStep =>
            List(rows.head(rowNumber)) ++ findValues(rest, rows.tail, rowNumber)
          case RightStep =>
            List(rows.head(rowNumber)) ++ findValues(
              rest,
              rows.tail,
              rowNumber + 1
            )
        }

    }
  }
}
