package xyz.casperkoning

import domain._

import com.typesafe.config._

import classy.config._
import classy.generic._
import classy.generic.derive._
import classy.generic.derive.NamingStrategy._

package object custom {
  object naming {
    object KebabCase extends SplitJoinNamingStrategy(StringSplitter.split)(
      _.map(_.toLowerCase).mkString("-"))
  }

  object decoders {
    import xyz.casperkoning.domain.VerySpecialCustomSettings

    implicit val verySpecialCustomSettingsDecoder: ConfigDecoder[VerySpecialCustomSettings] =
      readConfig[String]("first-field").join(
      readConfig[String]("second-field")).join(
      readConfig[Int]("version")).map {
        case (firstField, secondField, version) => VerySpecialCustomSettings(s"$firstField-$secondField-$version")
      }

    implicit val animalDecoder: ConfigDecoder[Animal] =
      makeDecoder[Config, Animal]
      .withOptions
      .typeCoproducts()
      .decoder
  }
}
