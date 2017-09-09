package io
package github
package aereal
package music

sealed trait Accidental
object Accidental {
  object Natural extends Accidental
  object Sharp extends Accidental
  object Flat extends Accidental
  object DoubleSharp extends Accidental
  object DoubleFlat extends Accidental
}

sealed abstract class PitchClass(val natural: PitchClass.Natural,
                                 val accidental: Accidental)
object PitchClass {
  sealed trait Natural
  object Natural {
    object C extends Natural
    object D extends Natural
    object E extends Natural
    object F extends Natural
    object G extends Natural
    object A extends Natural
    object H extends Natural

    val values: Seq[Natural] = C :: D :: E :: F :: G :: A :: H :: Nil
  }

  case object Ces extends PitchClass(Natural.C, Accidental.Flat)
  case object C extends PitchClass(Natural.C, Accidental.Natural)
  case object Cis extends PitchClass(Natural.C, Accidental.Sharp)
  case object Des extends PitchClass(Natural.D, Accidental.Flat)
  case object D extends PitchClass(Natural.D, Accidental.Natural)
  case object Dis extends PitchClass(Natural.D, Accidental.Sharp)
  case object Es extends PitchClass(Natural.E, Accidental.Flat)
  case object E extends PitchClass(Natural.E, Accidental.Natural)
  case object Eis extends PitchClass(Natural.E, Accidental.Sharp)
  case object Fes extends PitchClass(Natural.F, Accidental.Flat)
  case object F extends PitchClass(Natural.F, Accidental.Natural)
  case object Fis extends PitchClass(Natural.F, Accidental.Sharp)
  case object Ges extends PitchClass(Natural.G, Accidental.Flat)
  case object G extends PitchClass(Natural.G, Accidental.Natural)
  case object Gis extends PitchClass(Natural.G, Accidental.Sharp)
  case object As extends PitchClass(Natural.A, Accidental.Flat)
  case object A extends PitchClass(Natural.A, Accidental.Natural)
  case object Ais extends PitchClass(Natural.A, Accidental.Sharp)
  case object B extends PitchClass(Natural.H, Accidental.Flat)
  case object H extends PitchClass(Natural.H, Accidental.Natural)
  case object His extends PitchClass(Natural.H, Accidental.Sharp)

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
