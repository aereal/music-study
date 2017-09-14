package io
package github
package aereal
package music
package key

import pitch.PitchClass

class MajorKey(val center: PitchClass) extends Key {
  def tones: Seq[PitchClass] = {
    PitchClass.values.dropWhile(pc => pc != center).take(12).toList match {
      case _ :: _ :: ii :: _ :: iii :: iv :: _ :: v :: _ :: vi :: _ :: vii :: _ =>
        Seq(center, ii, iii, iv, v, vi, vii)
    }
  }
}
object MajorKey {
  def apply(center: PitchClass): MajorKey = new MajorKey(center)
}
