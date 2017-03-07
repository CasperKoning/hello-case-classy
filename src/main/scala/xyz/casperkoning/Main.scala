package xyz.casperkoning

import com.typesafe.config._

import classy.config._
import classy.generic._

import domain._
import custom.naming._
import custom.decoders._

object Main {
  def main(args: Array[String]): Unit = {

    val decoder = makeDecoder[Config, Settings]
      .withOptions
      .naming(KebabCase)
      .decoder

    val config = ConfigFactory.load().getConfig("xyz.casperkoning")

    decoder.decode(config) match {
      case Left(error) =>
        System.err.println("config error: " + error)
        System.exit(1)

      case Right(options) =>
        println(options)
    }
  }
}
