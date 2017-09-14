package io
package github
package aereal
package music
package key

import pitch.PitchClass

class MinorKey(val center: PitchClass) extends Key {
  def tones: Seq[PitchClass] = {
    PitchClass.values.dropWhile(pc => pc != center).take(12).toList match {
      case _ :: _ :: ii :: iii :: _ :: iv :: _ :: v :: vi :: _ :: vii :: _ =>
        Seq(center, ii, iii, iv, v, vi, vii)
    }
  }
}
object MinorKey {
  def apply(center: PitchClass): MinorKey = new MinorKey(center)
}
