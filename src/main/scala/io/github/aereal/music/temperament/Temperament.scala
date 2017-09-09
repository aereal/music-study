package io
package github
package aereal
package music
package temperament

trait Temperament {
  def pitchFor(frequency: Frequency): Option[Pitch]
}
object Temperament {}
