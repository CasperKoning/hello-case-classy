package xyz.casperkoning

import scala.util.{Left, Right}
import scala.util.control._

import classy.config.ConfigDecoder
import classy.core.DecodeError.Underlying
import classy.generic.derive.NamingStrategy._
import classy.generic.derive._

package object custom {
  object naming {
    object KebabCase extends SplitJoinNamingStrategy(StringSplitter.split)(
      _.map(_.toLowerCase).mkString("-"))
  }

  object decoders {
    import xyz.casperkoning.domain.VerySpecialCustomSettings
    import net.ceedubs.ficus.Ficus._

    implicit val verySpecialCustomSettingsDecoder: ConfigDecoder[VerySpecialCustomSettings] =
      ConfigDecoder.instance[VerySpecialCustomSettings](c => {
        try {
          val firstField = c.as[String]("first-field")
          val secondField = c.as[String]("second-field")
          val version = c.as[Int]("version")
          Right(new VerySpecialCustomSettings(s"$firstField-$secondField-$version"))
        } catch {
          case NonFatal(e) => Left(Underlying(e))
        }
      })
  }
}
