package xyz.casperkoning

import scala.concurrent.duration._
import org.scalatest._

import com.typesafe.config._

import classy.config._
import classy.generic._

import domain._
import custom.naming._
import custom.decoders._

class ClassyTest extends FlatSpec with Matchers {
  "Classy" should "help me with deriving decoders to decode my application.conf" in {
    val decoder = makeDecoder[Config, Settings]
      .withOptions
      .naming(KebabCase)
      .decoder

    val config = ConfigFactory.load().getConfig("xyz.casperkoning")

    decoder.decode(config) match {
      case Left(error) =>
        throw new Exception(s"config error: $error")

      case Right(settings) =>
        settings shouldEqual Settings(
          primitiveSettings = PrimitiveSettings(
            someInt = 1,
            someDouble = 1.0
          ),
          stringSettings = StringSettings(
            one = "one",
            two = "two"
          ),
          listSettings = ListSettings(
            someList = List(1, 2, 3)
          ),
          finiteDurationSettings = FiniteDurationSettings(
            someFiniteDuration = 5 days
          ),
          nestedSettings = NestedSettings(
            nest = Nest(int = 1)
          ),
          verySpecialCustomSettings = VerySpecialCustomSettings(
            composedField = "aaaa-bbbb-1"
          )
        )
    }
  }
}
