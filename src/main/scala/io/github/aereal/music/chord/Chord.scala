package io
package github
package aereal
package music
package chord

import pitch.PitchClass

trait Chord {
  def root: PitchClass
}
object Chord {
  trait Triad extends Chord {
    def third: PitchClass
    def fifth: PitchClass
    def thirdInterval: IntervalClass = third.intervalOf(root)
    def isMajor: Boolean = thirdInterval == IntervalClass.MajorThird
    def isMinor: Boolean = thirdInterval == IntervalClass.MinorThird
  }
  object Triad {
    def apply(t1: PitchClass, t2: PitchClass, t3: PitchClass): Triad =
      new Triad {
        val root = t1
        val third = t2
        val fifth = t3
      }
  }
}
