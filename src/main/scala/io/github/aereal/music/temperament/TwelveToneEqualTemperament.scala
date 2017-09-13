package io
package github
package aereal
package music
package temperament

import pitch.PitchClass
import scala.math.BigDecimal
import music.{Pitch => BasePitch}

object TwelveToneEqualTemperament extends Temperament {
  object Implicits {
    implicit val twelveToneEqualTemperament = TwelveToneEqualTemperament
  }

  def pitchFor(frequency: Frequency): Option[BasePitch] =
    pitchClassFor(frequency).map(pitchClass =>
      new Pitch(frequency, pitchClass))

  def pitchClassFor(frequency: Frequency): Option[PitchClass] =
    frequency match {
      case Extractor.C(pitchClass) => Some(pitchClass)
      case Extractor.Des(pitchClass) => Some(pitchClass)
      case Extractor.D(pitchClass) => Some(pitchClass)
      case Extractor.Es(pitchClass) => Some(pitchClass)
      case Extractor.E(pitchClass) => Some(pitchClass)
      case Extractor.F(pitchClass) => Some(pitchClass)
      case Extractor.Ges(pitchClass) => Some(pitchClass)
      case Extractor.G(pitchClass) => Some(pitchClass)
      case Extractor.As(pitchClass) => Some(pitchClass)
      case Extractor.A(pitchClass) => Some(pitchClass)
      case Extractor.B(pitchClass) => Some(pitchClass)
      case Extractor.H(pitchClass) => Some(pitchClass)
      case _ => None
    }

  def intervalOf(a: BasePitch, b: BasePitch): Interval = {
    new Interval(a.frequency.value / b.frequency.value)
  }

  val halfToneRatio: BigDecimal = BigDecimal(scala.math.pow(2, 1f / 12f))

  class Pitch(val frequency: Frequency, val pitchClass: PitchClass)
      extends BasePitch
  object Pitch {
    val ratio = halfToneRatio
    val A4 = new Pitch(Frequency(BigDecimal(442)), PitchClass.A)
    val B4 = new Pitch(A4.frequency * ratio, PitchClass.B)
    val H4 = new Pitch(B4.frequency * ratio, PitchClass.H)
    val As4 = new Pitch(A4.frequency / ratio, PitchClass.As)
    val G4 = new Pitch(As4.frequency / ratio, PitchClass.G)
    val Ges4 = new Pitch(G4.frequency / ratio, PitchClass.Ges)
    val F4 = new Pitch(Ges4.frequency / ratio, PitchClass.F)
    val E4 = new Pitch(F4.frequency / ratio, PitchClass.E)
    val Es4 = new Pitch(E4.frequency / ratio, PitchClass.Es)
    val D4 = new Pitch(Es4.frequency / ratio, PitchClass.D)
    val Des4 = new Pitch(D4.frequency / ratio, PitchClass.Des)
    val C4 = new Pitch(Des4.frequency / ratio, PitchClass.C)
  }

  private class Extractor(pitch: Pitch) {
    def unapply(frequency: Frequency): Option[PitchClass] =
      if (multipleOf(pitch.frequency)(frequency)) Some(pitch.pitchClass)
      else None

    private def multipleOf(x: Frequency)(y: Frequency): Boolean = {
      val (a, b) = if (x.value > y.value) (y, x) else (x, y)
      (b.value % a.value) == 0
    }
  }
  private object Extractor {
    val C = new Extractor(Pitch.C4)
    val Des = new Extractor(Pitch.Des4)
    val D = new Extractor(Pitch.D4)
    val Es = new Extractor(Pitch.Es4)
    val E = new Extractor(Pitch.E4)
    val F = new Extractor(Pitch.F4)
    val Ges = new Extractor(Pitch.Ges4)
    val G = new Extractor(Pitch.G4)
    val As = new Extractor(Pitch.As4)
    val A = new Extractor(Pitch.A4)
    val B = new Extractor(Pitch.B4)
    val H = new Extractor(Pitch.H4)
  }
}
