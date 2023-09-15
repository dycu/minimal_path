package com.dycjan

import cats.Show
import cats.effect.kernel.Resource
import cats.effect.{ExitCode, IO, IOApp}
import com.dycjan.domain.Triangle

import scala.io.{Source, StdIn}

object Main extends IOApp.Simple {

  private val pathFollower = new PathFollower()
  private val triangleParser = new TriangleParser()
  private val minimalPathCalculator = new MinimalPathCalculator(pathFollower)

  def run: IO[Unit] = {
    (for {
      _ <- IO(print("Input file name: "))
      fileName <- IO(StdIn.readLine())
      result <- Resource
        .fromAutoCloseable(IO.delay(Source.fromFile(fileName)))
        .use { input =>
          runProgram(input.getLines().toList)
        }
    } yield result).as(ExitCode.Success)
  }

  def runProgram(input: List[String]): IO[Unit] = {
    val triangle = triangleParser.parseInput(input)
    val minimalPath = minimalPathCalculator.findMinimalPath(triangle)

    IO {
      println("Triangle: ")
      println(Show[Triangle].show(triangle))
      println("Result: ")
      println(
        s"${minimalPath.map(_.v).mkString(" + ")} = ${minimalPath.map(_.v).sum}"
      )
    }
  }

}
