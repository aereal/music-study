package io
package github
package aereal
package music
package interval

sealed trait Quality
sealed trait MajorOrMinorOrPerfect extends Quality
sealed trait AugmentedOrDiminished extends Quality
object Quality {
  case object Perfect extends MajorOrMinorOrPerfect
  case object Major extends MajorOrMinorOrPerfect
  case object Minor extends MajorOrMinorOrPerfect
  case object Augmented extends AugmentedOrDiminished
  case object Diminished extends AugmentedOrDiminished
}

case class Interval(number: Number, quality: Quality) {
  val semiTones: Int = {
    number match {
      case Number.First =>
        quality match {
          case Quality.Perfect => 0
          case Quality.Augmented => 1
        }
      case Number.Second =>
        quality match {
          case Quality.Diminished => 0
          case Quality.Minor => 1
          case Quality.Major => 2
          case Quality.Augmented => 3
        }
      case Number.Third =>
        quality match {
          case Quality.Diminished => 2
          case Quality.Minor => 3
          case Quality.Major => 4
          case Quality.Augmented => 5
        }
      case Number.Fourth =>
        quality match {
          case Quality.Diminished => 4
          case Quality.Perfect => 5
          case Quality.Augmented => 6
        }
      case Number.Fifth =>
        quality match {
          case Quality.Diminished => 6
          case Quality.Perfect => 7
          case Quality.Augmented => 8
        }
      case Number.Sixth =>
        quality match {
          case Quality.Diminished => 7
          case Quality.Minor => 8
          case Quality.Major => 9
          case Quality.Augmented => 10
        }
      case Number.Seventh =>
        quality match {
          case Quality.Diminished => 9
          case Quality.Minor => 10
          case Quality.Major => 11
          case Quality.Augmented => 12
        }
      case Number.Eighth =>
        quality match {
          case Quality.Diminished => 11
          case Quality.Perfect => 12
        }
    }
  }
}
object Interval {
  val Unison = Interval(Number.First, Quality.Perfect)
  val Octave = Interval(Number.Eighth, Quality.Perfect)
}
