package com.dycjan

import cats.Show
import com.dycjan.domain.{Triangle, Value}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TriangleParserSpec extends AnyWordSpec with Matchers{

  val parser = new TriangleParser

  "Parsing lines" when {
    "there's a single line" should {
      "parse it to leaf" in {
        val result = parser.parseInput(List("1"))
        println(Show[Triangle].show(result))
          result shouldEqual Triangle(List(List(Value(1))))
      }
    }

    "there's multiple lines" should {
      "parse it to node with leaves" in {
        val result = parser.parseInput(List("1", "1 2"))
        println(Show[Triangle].show(result))
        result shouldEqual Triangle(List(List(Value(1)), List(Value(1), Value(2))))
      }
    }
  }

}
