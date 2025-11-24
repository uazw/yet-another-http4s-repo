package io.github.uazw.rebrith

import cats.effect.IOApp
import cats.effect.ExitCode
import cats.effect.IO
import cats.syntax.applicative._

object Main extends IOApp:
  def run(args: List[String]): IO[ExitCode] = IO.println("hello world") >> ExitCode.Success.pure[IO]
