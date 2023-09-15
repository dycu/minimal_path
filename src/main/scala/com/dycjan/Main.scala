package com.dycjan

import cats.effect.{IO, IOApp}

import scala.io.StdIn

object Main extends IOApp.Simple {

  val inputReader = new InputReader

  def run: IO[Unit] = {
    for {
      _ <- IO(println("Input file name:"))
      fileName <- IO(StdIn.readLine())
      _ <- inputReader.readInput(fileName)
    } yield ()
  }

}
