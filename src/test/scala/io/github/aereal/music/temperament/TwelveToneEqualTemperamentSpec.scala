package io
package github
package aereal
package music
package temperament

import java.math.MathContext

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

    it("pitch interval") {
      import TwelveToneEqualTemperament.Pitch

      val interval = TwelveToneEqualTemperament.intervalOf(Pitch.D4, Pitch.C4)
      interval.halfTones shouldBe 2
    }
  }
}
