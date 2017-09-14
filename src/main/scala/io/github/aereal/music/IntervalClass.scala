package io
package github
package aereal
package music

case class IntervalClass(halfTones: Int)
object IntervalClass {
  val Same = IntervalClass(0)
  val HalfTone = IntervalClass(1)
  val WholeTone = IntervalClass(2)
}
