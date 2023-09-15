package com.dycjan

import cats.effect.IO
import cats.implicits._
import com.dycjan.domain.{BinaryTree, Leaf, Node, Value}

/**
 * It's going to parse the input which is in form of line of strings
 * into proper data structure.
 */
class TriangleParser {

  def parseInput(lines: List[String]): BinaryTree = {
    val values = lines.map(line => line.split(" ").toList.map(_.toInt))

    buildNode(values, 0, 0)
  }

  private def buildNode(input: List[List[Int]], x: Int, y: Int): BinaryTree = {
    val v = input(x)(y)
    val left = input.get(x+1).flatMap(_.get(y))
    val right = input.get(x+1).flatMap(_.get(y + 1))

    (left, right) match {
      case (Some(_), Some(_)) => Node(Value(v), buildNode(input, x+1, y), buildNode(input, x+1, y+1))
      case (_, _) => Leaf(Value(v))
    }
  }


}