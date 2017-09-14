package io
package github
package aereal
package music

sealed abstract class IntervalClass(val halfTones: Int)
object IntervalClass {
  case object HalfTone extends IntervalClass(1)
  case object WholeTone extends IntervalClass(2)
}
