package io
package github
package aereal
package music

import scala.math.BigDecimal

class Frequency(val value: BigDecimal) extends AnyVal {
  def *(ratio: BigDecimal): Frequency = new Frequency(value * ratio)

  def /(ratio: BigDecimal): Frequency = new Frequency(value / ratio)

  override def toString: String = s"Frequency(${this.value})"
}
object Frequency {
  def apply(bigDecimal: BigDecimal): Frequency = new Frequency(bigDecimal)

  implicit val orderingFrequency: Ordering[Frequency] = Ordering.by(_.value)
}
