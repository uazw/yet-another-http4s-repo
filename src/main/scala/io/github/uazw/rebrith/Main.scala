package io.github.uazw.rebrith

import cats.effect.IOApp
import cats.effect.ExitCode
import cats.effect.IO
import cats.syntax.applicative._
import cats.syntax.semigroupk._
import org.http4s.ember.server.EmberServerBuilder
import com.comcast.ip4s.Literals.ipv4
import org.typelevel.log4cats.LoggerFactory
import org.typelevel.log4cats.slf4j.Slf4jFactory
import com.comcast.ip4s._
import org.http4s.HttpRoutes
import org.http4s.dsl.io._

object Main extends IOApp:

  given LoggerFactory[IO] = Slf4jFactory.create[IO]

  def run(args: List[String]): IO[ExitCode] =
    val routes = HttpRoutes.of[IO] { case GET -> Root / "hello" =>
      Ok("Hello, World!")
    }

    EmberServerBuilder
      .default[IO]
      .withHost(ipv4"0.0.0.0")
      .withPort(port"8080")
      .withHttpApp((routes <+> routes).orNotFound)
      .build
      .use(_ => IO.never) >> ExitCode.Success.pure[IO]
