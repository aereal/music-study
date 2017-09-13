package io
package github
package aereal
package music
package pitch

import temperament.Temperament

trait Pitch {
  def frequency: Frequency
  def pitchClass: PitchClass
}
object Pitch {
  def apply(frequency: Frequency)(
      implicit temperament: Temperament): Option[Pitch] =
    temperament.pitchFor(frequency)

  implicit val orderingPitch: Ordering[Pitch] = Ordering.by(_.frequency)
}
