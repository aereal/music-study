package io
package github
package aereal
package music
package key

import pitch.PitchClass

trait Key {
  def center: PitchClass
  def tones: Seq[PitchClass]
  def tonesStream: Stream[PitchClass] = Stream.iterate[PitchClass](center) {
    prev =>
      tones.indexOf(prev) match {
        case -1 => sys.error("BUG")
        case last if last == (tones.size - 1) => tones.head
        case idx => tones(idx + 1)
      }
  }
}
