package io
package github
package aereal
package music
package temperament

class TwelveToneEqualTemperamentSpec extends BaseSpec {
  describe("12-tone equal temperament") {
    import TwelveToneEqualTemperament.Implicits._

    it("creates a Pitch with a PitchClass corresponds to frequency") {
      val pitch1 = Pitch(Frequency(442)).value
      val pitch2 = Pitch(Frequency(884)).value
      val pitch3 =
        Pitch(TwelveToneEqualTemperament.Pitch.B4.frequency).value
      pitch1.pitchClass shouldBe PitchClass.A
      pitch2.pitchClass shouldBe PitchClass.A
      pitch3.pitchClass shouldBe PitchClass.B
    }

    describe("intervalOf") {
      import TwelveToneEqualTemperament.Pitch

      it("returns whole tone interval") {
        val interval =
          TwelveToneEqualTemperament.intervalOf(Pitch.D4, Pitch.C4)
        interval.halfTones shouldBe 2
      }

      it("returns 0 if same pitch") {
        val interval =
          TwelveToneEqualTemperament.intervalOf(Pitch.D4, Pitch.D4)
        interval.halfTones shouldBe 0
      }
    }
  }
}
