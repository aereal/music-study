package io
package github
package aereal
package music

sealed abstract class PitchClass
object PitchClass {
  case object Ces extends PitchClass
  case object C extends PitchClass
  case object Cis extends PitchClass
  case object Des extends PitchClass
  case object D extends PitchClass
  case object Dis extends PitchClass
  case object Es extends PitchClass
  case object E extends PitchClass
  case object Fes extends PitchClass
  case object F extends PitchClass
  case object Eis extends PitchClass
  case object Fis extends PitchClass
  case object Ges extends PitchClass
  case object G extends PitchClass
  case object Gis extends PitchClass
  case object As extends PitchClass
  case object A extends PitchClass
  case object Ais extends PitchClass
  case object B extends PitchClass
  case object H extends PitchClass
  case object His extends PitchClass

  val values: Seq[PitchClass] =
    Ces :: C :: Cis ::
      Des :: D :: Dis ::
      Es :: E :: Eis ::
      Fes :: F :: Fis ::
      Ges :: G :: Gis ::
      As :: A :: Ais ::
      B :: H :: His ::
      Nil
}
