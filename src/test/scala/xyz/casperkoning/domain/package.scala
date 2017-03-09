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

  sealed trait Planet
  case object Earth extends Planet
  case object Mars extends Planet
  case object Pluto extends Planet
  case class ArbitraryPlanet(distance: Int) extends Planet

  sealed trait Animal
  case object Cat extends Animal
  case object Dog extends Animal
  case class HummingBird(species: String) extends Animal

  case class Settings(
    primitiveSettings: PrimitiveSettings,
    stringSettings: StringSettings,
    listSettings: ListSettings,
    finiteDurationSettings: FiniteDurationSettings,
    nestedSettings: NestedSettings,
    verySpecialCustomSettings: VerySpecialCustomSettings,
    planets: List[Planet],
    animals: List[Animal]
  )

}
