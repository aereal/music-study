package io
package github
package aereal
package music
package pitch

sealed abstract class PitchClass(val label: String) {
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
  case object C extends PitchClass("C")
  case object Cis extends PitchClass("Cis")
  val Des = Cis
  case object D extends PitchClass("D")
  case object Dis extends PitchClass("Dis")
  val Es = Dis
  case object E extends PitchClass("E")
  val Fes = E
  case object F extends PitchClass("F")
  val Eis = F
  case object Fis extends PitchClass("Fis")
  val Ges = Fis
  case object G extends PitchClass("G")
  case object Gis extends PitchClass("Gis")
  val As = Gis
  case object A extends PitchClass("A")
  case object Ais extends PitchClass("B")
  val B = Ais
  case object H extends PitchClass("H")
  val Ces = H
  val His = C

  private val minimalValues = Seq(C, Cis, D, Dis, E, F, Fis, G, Gis, A, B, H)

  val values = Stream.iterate[PitchClass](C)(_.next)

  def from(name: String): Option[PitchClass] = name match {
    case "C" => Some(C)
    case "Cis" | "Des" => Some(Cis)
    case "D" => Some(D)
    case "Dis" | "Es" => Some(Dis)
    case "E" => Some(E)
    case "F" => Some(F)
    case "Fis" | "Ges" => Some(Fis)
    case "G" => Some(G)
    case "Gis" | "As" => Some(Gis)
    case "A" => Some(A)
    case "Ais" | "B" => Some(B)
    case "H" => Some(H)
    case _ => None
  }
}
