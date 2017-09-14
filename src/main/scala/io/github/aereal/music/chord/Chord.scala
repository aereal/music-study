package io
package github
package aereal
package music
package chord

import pitch.PitchClass
import key.Key

trait Chord {
  def root: PitchClass
  protected def tones: Set[PitchClass]

  override def equals(rhs: Any): Boolean = rhs match {
    case other: Chord => this.tones == other.tones
    case _ => false
  }

  override def toString: String = s"Chord(${tones.mkString(",")})"
}
object Chord {
  trait Triad extends Chord {
    protected def tones: Set[PitchClass] = Set(root, third, fifth)
    def third: PitchClass
    def fifth: PitchClass
    def thirdInterval: IntervalClass = third.intervalOf(root)
    def fifthInterval: IntervalClass = fifth.intervalOf(root)
    def isMajor: Boolean = thirdInterval == IntervalClass.MajorThird
    def isMinor: Boolean = thirdInterval == IntervalClass.MinorThird
    def isTriad: Boolean =
      fifthInterval == IntervalClass.PerfectFifth || fifthInterval == IntervalClass.AugmentedFifth || fifthInterval == IntervalClass.DiminishedFifth
  }
  object Triad {
    def major(root: PitchClass): Triad = Triad(
      root,
      root + IntervalClass.MajorThird,
      root + IntervalClass.PerfectFifth
    )

    def minor(root: PitchClass): Triad = Triad(
      root,
      root + IntervalClass.MinorThird,
      root + IntervalClass.PerfectFifth
    )

    def apply(t1: PitchClass, t2: PitchClass, t3: PitchClass): Triad =
      new Triad {
        val root = t1
        val third = t2
        val fifth = t3
      }

    def from(key: Key, position: ChordPosition): Triad = {
      key.tonesStream.drop(position.offset).take(5).toList match {
        case root :: _ :: third :: _ :: fifth :: Nil =>
          Triad(root, third, fifth)
        case _ => sys.error("key does not have enough tones")
      }
    }
  }
}
