package io
package github
package aereal
package music

case class IntervalClass(halfTones: Int)
object IntervalClass {
  val Same = IntervalClass(0)
  val HalfTone = IntervalClass(1)
  val WholeTone = IntervalClass(2)
  val MinorThird = IntervalClass(3)
  val MajorThird = IntervalClass(4)
  val PerfectFourth = IntervalClass(5)
  val Tritone = IntervalClass(6)
  val DiminishedFifth = Tritone
  val PerfectFifth = IntervalClass(7)
  val MinorSixth = IntervalClass(8)
  val AugmentedFifth = MinorSixth
  val MajorSixth = IntervalClass(9)
  val MinorSeventh = IntervalClass(10)
  val MajorSeventh = IntervalClass(11)
  val PerfectOctave = IntervalClass(12)
}
