package com.dycjan

import cats.Show
import cats.effect.{IO, Resource}
import com.dycjan.domain.Triangle

import scala.io.Source

/** Reads the data from the standard input.
  */
class InputReader(
    triangleParser: TriangleParser,
    minimalPathCalculator: MinimalPathCalculator
) {

  def readInput(fileName: String): IO[List[String]] =
    Resource.fromAutoCloseable(IO.delay(Source.fromFile(fileName))).use {
      input =>
        val triangle = triangleParser.parseInput(input.getLines().toList)
        println(Show[Triangle].show(triangle))
        val minimalPath = minimalPathCalculator.calculateMinimalPath(triangle)
        println(minimalPath)

        IO(List.empty)
    }

}
