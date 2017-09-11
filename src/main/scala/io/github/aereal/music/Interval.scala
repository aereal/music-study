package io
package github
package aereal
package music

class Interval(val halfTones: Int) extends AnyVal
object Interval {
  def apply(halfTones: Int): Interval = new Interval(halfTones)
}
