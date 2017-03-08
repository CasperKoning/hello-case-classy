package xyz.casperkoning

import scala.concurrent.duration.FiniteDuration

package object domain {

  case class PrimitiveSettings(someInt: Int, someDouble: Double)

  case class StringSettings(one: String, two: String)

  case class ListSettings(someList: List[Int])

  case class FiniteDurationSettings(someFiniteDuration: FiniteDuration)

  case class NestedSettings(nest: Nest)

  case class Nest(int: Int)

  case class VerySpecialCustomSettings(composedField: String)

  case class Settings(
    primitiveSettings: PrimitiveSettings,
    stringSettings: StringSettings,
    listSettings: ListSettings,
    finiteDurationSettings: FiniteDurationSettings,
    nestedSettings: NestedSettings,
    verySpecialCustomSettings: VerySpecialCustomSettings
  )

}
