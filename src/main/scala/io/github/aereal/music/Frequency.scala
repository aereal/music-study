package io
package github
package aereal
package music

class Frequency(val value: Float) extends AnyVal
object Frequency {
  def apply(int: Int): Frequency = new Frequency(int.toFloat)
}
