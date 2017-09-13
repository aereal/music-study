package io
package github
package aereal
package music

import scala.collection.SortedSet

abstract class Chord(tones: SortedSet[pitch.Pitch]) {
  def root: pitch.Pitch = tones.head
}
object Chord {
  private case class Impl(tones: SortedSet[pitch.Pitch]) extends Chord(tones)

  def apply(p1: pitch.Pitch, p2: pitch.Pitch, rest: pitch.Pitch*): Chord = {
    val tones = p1 :: p2 :: rest.toList
    Impl(SortedSet(tones: _*))
  }
}
