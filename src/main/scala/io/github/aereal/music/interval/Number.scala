package io
package github
package aereal
package music
package interval

case class Number(val value: Int) extends AnyVal {
  def +(rhs: Number): Number = {
    val lhs = if (value == 1) 1 else value - 1
    Number(lhs + (rhs.value - 1) + 1)
  }

  def -(rhs: Number): Number = {
    val lhs = if (value == 1) Number(8) else this
    Number(lhs.value - rhs.value)
  }
}
object Number {
  final val First = Number(1)
  final val Second = Number(2)
  final val Third = Number(3)
  final val Fourth = Number(4)
  final val Fifth = Number(5)
  final val Sixth = Number(6)
  final val Seventh = Number(7)
  final val Eighth = Number(8)

  def apply(value: Int): Number = new Number(value)
}
