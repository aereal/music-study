package io
package github
package aereal
package music

import scala.collection.SortedSet

case class Chord private (tones: SortedSet[pitch.Pitch])
object Chord {
  def apply(p1: pitch.Pitch, p2: pitch.Pitch, rest: pitch.Pitch*): Chord = {
    val tones = p1 :: p2 :: rest.toList
    Chord(SortedSet(tones: _*))
  }
}
