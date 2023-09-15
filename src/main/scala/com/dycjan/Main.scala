package com.dycjan

import cats.effect.{IO, IOApp}

import scala.io.StdIn

object Main extends IOApp.Simple {

  private val pathFollower = new PathFollower()
  private val triangleParser = new TriangleParser()
  private val minimalPathCalculator = new MinimalPathCalculator(pathFollower)
  val inputReader = new InputReader(triangleParser, minimalPathCalculator)

  def run: IO[Unit] = {
    for {
      _ <- IO(println("Input file name:"))
      fileName <- IO(StdIn.readLine())
      _ <- inputReader.readInput(fileName)
    } yield ()
  }

}
