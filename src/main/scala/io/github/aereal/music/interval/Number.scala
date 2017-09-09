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
  def apply(value: Int): Number = new Number(value)
}
