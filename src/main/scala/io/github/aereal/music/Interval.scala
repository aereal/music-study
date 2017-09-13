package io
package github
package aereal
package music

import temperament.Temperament

class Interval(val ratio: BigDecimal) extends AnyVal {
  def halfTones(implicit temp: Temperament): Int = {
    log(ratio, temp.halfToneRatio)
      .setScale(0, BigDecimal.RoundingMode.HALF_EVEN)
      .toInt
  }

  private def log(base: BigDecimal, anti: BigDecimal): BigDecimal = {
    val x = BigDecimal(scala.math.log(base.doubleValue()), base.mc)
    val y = BigDecimal(scala.math.log(anti.doubleValue()), anti.mc)
    x / y
  }
}
