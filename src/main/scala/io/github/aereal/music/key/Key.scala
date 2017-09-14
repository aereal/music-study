package io
package github
package aereal
package music
package key

import pitch.PitchClass

trait Key {
  def center: PitchClass
  def tones: Seq[PitchClass]
}
