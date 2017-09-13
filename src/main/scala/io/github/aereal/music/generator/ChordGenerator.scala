package io
package github
package aereal
package music
package generator

import chord.ChordPosition
import scala.util.Random

class ChordGenerator protected (
    val previousChordPosition: Option[ChordPosition]) {
  import ChordPosition._

  def isStarted: Boolean = previousChordPosition.isDefined

  def candidates: Set[ChordPosition] = previousChordPosition match {
    case None => Set(I, IV, V)
    case Some(I) => Set(II, III, IV, V, VI, VII) // TODO: seventh
    case Some(II) => Set(V) // TODO: seventh
    case Some(III) => Set(IV) // TODO: dominant
    case Some(IV) => Set(I, II, V) // TODO: seventh
    case Some(V) => Set(I, VI) // TODO: borrowed
    case Some(VI) => Set(II, III, IV, V, VII)
    case Some(VII) => Set(III)
  }

  def generate(): (ChordPosition, ChordGenerator) = {
    val nextChord = Random.shuffle(candidates.toSeq).head
    val nextGenerator = new ChordGenerator(Some(nextChord))
    (nextChord, nextGenerator)
  }
}
object ChordGenerator {
  def apply(): ChordGenerator = new ChordGenerator(None)
}
