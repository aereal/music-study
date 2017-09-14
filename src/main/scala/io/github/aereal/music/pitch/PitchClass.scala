package io
package github
package aereal
package music
package pitch

sealed abstract class PitchClass {
  def next: PitchClass = PitchClass.minimalValues.indexOf(this) match {
    case -1 => sys.error("BUG")
    case last if last == (PitchClass.minimalValues.size - 1) =>
      PitchClass.minimalValues.head
    case idx => PitchClass.minimalValues(idx + 1)
  }

  def +(interval: IntervalClass): PitchClass =
    PitchClass.values.dropWhile(p => p != this).drop(interval.halfTones).head

  def intervalOf(other: PitchClass): IntervalClass = {
    val a = PitchClass.minimalValues.indexOf(this)
    val b = PitchClass.minimalValues.indexOf(other)
    IntervalClass(a - b)
  }
}
object PitchClass {
  case object C extends PitchClass
  case object Cis extends PitchClass
  val Des = Cis
  case object D extends PitchClass
  case object Dis extends PitchClass
  val Es = Dis
  case object E extends PitchClass
  val Fes = E
  case object F extends PitchClass
  val Eis = F
  case object Fis extends PitchClass
  val Ges = Fis
  case object G extends PitchClass
  case object Gis extends PitchClass
  val As = Gis
  case object A extends PitchClass
  case object Ais extends PitchClass
  val B = Ais
  case object H extends PitchClass
  val Ces = H
  val His = C

  private val minimalValues = Seq(C, Cis, D, Dis, E, F, Fis, G, Gis, A, B, H)

  val values = Stream.iterate[PitchClass](C)(_.next)
}
