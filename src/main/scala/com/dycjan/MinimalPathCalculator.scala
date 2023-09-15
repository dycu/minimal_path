package com.dycjan

import com.dycjan.domain.Step.{LeftStep, RightStep}
import com.dycjan.domain.{Path, Triangle, Value}

import scala.annotation.tailrec

case class Pair(left: Min, right: Min)

case class Min(minValue: Value, takenPath: Path)

/** Solves the problem.
  */
class MinimalPathCalculator(pathFollower: PathFollower) {

  def calculateMinimalPath(triangle: Triangle): List[Value] = {
    val initial =
      triangle.values.map(vs => vs.map(v => Min(v, Path(List.empty)))).reverse

    pathFollower.findValues(
      Path(findPath(initial).takenPath.steps.reverse).steps,
      triangle.values,
      0,
      0
    )
  }

  @tailrec
  private def findPath(rows: List[List[Min]]): Min = {
    rows match {
      case lastRow :: Nil =>
        lastRow.head
      case firstRow :: restOfRows =>
        findPath(addMinsToRow(calculateCosts(firstRow), restOfRows))
    }
  }

  private def calculateCosts(row: List[Min]): List[Min] = {
    pairValues(row).map {
      case Pair(left, right) if left.minValue.v < right.minValue.v =>
        Min(left.minValue, Path(left.takenPath.steps ++ List(LeftStep)))
      case Pair(left, right) if right.minValue.v < left.minValue.v =>
        Min(right.minValue, Path(right.takenPath.steps ++ List(RightStep)))
      case Pair(left, right) if left.minValue.v == right.minValue.v =>
        Min(left.minValue, Path(left.takenPath.steps ++ List(LeftStep)))
    }
  }

  private def pairValues(row: List[Min]): List[Pair] = {
    row.indices
      .dropRight(1)
      .map { idx =>
        Pair(row(idx), row(idx + 1))
      }
      .toList
  }

  private def addMinsToRow(
      calculatedMins: List[Min],
      rowsLeft: List[List[Min]]
  ): List[List[Min]] = {
    val newRow = rowsLeft.head.zip(calculatedMins).map { case (old, added) =>
      Min(
        Value(old.minValue.v + added.minValue.v),
        Path(old.takenPath.steps ++ added.takenPath.steps)
      )
    }

    List(newRow) ++ rowsLeft.tail
  }

}
