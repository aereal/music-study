package io
package github
package aereal
package music
package temperament

trait Temperament {
  def pitchFor(frequency: Frequency): Option[Pitch]
  def intervalOf(a: Pitch, b: Pitch): Interval
  def halfToneRatio: BigDecimal
}
object Temperament {}
