package io
package github
package aereal
package music
package pitch

class PitchSpec extends BaseSpec {
  describe("12-tone equal temperament") {
    import temperament.TwelveToneEqualTemperament.Pitch._

    it("is sorted by its frequency") {
      val tones = Seq(A4, C4, G4, D4)
      val sorted = tones.sorted
      sorted shouldBe Seq(C4, D4, G4, A4)
    }
  }
}
