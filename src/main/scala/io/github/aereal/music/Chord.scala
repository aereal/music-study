package io
package github
package aereal
package music

import pitch.Pitch
import scala.collection.SortedSet

abstract class Chord(tones: SortedSet[Pitch]) {
  def root: Pitch = tones.head
}
object Chord {
  private case class Impl(tones: SortedSet[Pitch]) extends Chord(tones)

  def apply(p1: Pitch, p2: Pitch, rest: Pitch*): Chord = {
    val tones = p1 :: p2 :: rest.toList
    Impl(SortedSet(tones: _*))
  }
}
