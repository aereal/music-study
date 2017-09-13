package io
package github
package aereal
package music

import pitch.Pitch
import scala.collection.SortedSet

abstract class Chord(tones: SortedSet[Pitch]) {
  private val tonesList = tones.toList

  def root: Pitch = tones.head

  def second: Pitch = tonesList match {
    case _ :: second :: _ => second
  }
}
object Chord {
  private case class Impl(tones: SortedSet[Pitch]) extends Chord(tones)

  def apply(p1: Pitch, p2: Pitch, rest: Pitch*): Chord = {
    val tones = p1 :: p2 :: rest.toList
    Impl(SortedSet(tones: _*))
  }
}
