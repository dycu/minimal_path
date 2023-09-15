package com.dycjan

import cats.Show
import com.dycjan.domain.{BinaryTree, Leaf, Node, Value}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TriangleParserSpec extends AnyWordSpec with Matchers{

  val parser = new TriangleParser

  "Parsing lines" when {
    "there's a single line" should {
      "parse it to leaf" in {
        val result = parser.parseInput(List("1"))
        println(Show[BinaryTree].show(result))
          result shouldEqual Leaf(Value(1))
      }
    }

    "there's multiple lines" should {
      "parse it to node with leaves" in {
        val result = parser.parseInput(List("1", "1 2"))
        println(Show[BinaryTree].show(result))
        result shouldEqual Node(Value(1), Leaf(Value(1)), Leaf(Value(2)))
      }
    }
  }

}
