package io
package github
package aereal
package music

class ChordSpec extends BaseSpec {
  describe("Chord") {
    import temperament.TwelveToneEqualTemperament.Implicits._
    import temperament.TwelveToneEqualTemperament.Pitch._

    describe("equality") {
      it("is derived from its tones") {
        val ch1 = Chord(C4, E4, G4)
        val ch2 = Chord(E4, G4, C4)
        ch1 shouldBe ch2
      }
    }

    describe("root") {
      it("is lowest pitch") {
        val c = Chord(E4, G4, C4)
        c.root shouldBe C4
      }
    }
  }
}
