package io
package github
package aereal
package music

sealed abstract class PitchClass
object PitchClass {
  case object C extends PitchClass
  case object Cis extends PitchClass
  val Des = Cis
  case object D extends PitchClass
  case object Dis extends PitchClass
  val Es = Dis
  case object E extends PitchClass
  val Fes = E
  case object F extends PitchClass
  val Eis = F
  case object Fis extends PitchClass
  val Ges = Fis
  case object G extends PitchClass
  case object Gis extends PitchClass
  val As = Gis
  case object A extends PitchClass
  case object Ais extends PitchClass
  val B = Ais
  case object H extends PitchClass
  val Ces = H
  val His = C
}
