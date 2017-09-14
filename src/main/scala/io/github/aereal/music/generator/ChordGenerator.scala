package io
package github
package aereal
package music
package generator

import chord.ChordPosition
import scala.util.Random

class ChordGenerator protected (val reversedChordsQueue: List[ChordPosition]) {
  import ChordPosition._

  def isStarted: Boolean = !reversedChordsQueue.isEmpty

  def candidates: Set[ChordPosition] = reversedChordsQueue match {
    case Nil => Set(I, IV, V)
    case I :: _ => Set(II, III, IV, V, VI, VII) // TODO: seventh
    case II :: _ => Set(V) // TODO: seventh
    case III :: _ => Set(IV) // TODO: dominant
    case IV :: _ => Set(I, II, V) // TODO: seventh
    case V :: _ => Set(I, VI) // TODO: borrowed
    case VI :: _ => Set(II, III, IV, V, VII)
    case VII :: _ => Set(III)
  }

  def generate(): (ChordPosition, ChordGenerator) = {
    val nextChord = Random.shuffle(candidates.toSeq).head
    val nextGenerator = new ChordGenerator(nextChord :: reversedChordsQueue)
    (nextChord, nextGenerator)
  }
}
object ChordGenerator {
  def apply(): ChordGenerator = new ChordGenerator(Nil)
}
