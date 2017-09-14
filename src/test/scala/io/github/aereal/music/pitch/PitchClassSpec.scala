package io
package github
package aereal
package music
package pitch

class PitchClassSpec extends BaseSpec {
  describe("PitchClass") {
    it("has a next reference") {
      PitchClass.C.next shouldBe PitchClass.Cis
      PitchClass.H.next shouldBe PitchClass.C
    }

    it("has a difference between other pitch class") {
      val i1 = PitchClass.C.intervalOf(PitchClass.C)
      i1 shouldBe IntervalClass.Same

      val i2 = PitchClass.D.intervalOf(PitchClass.C)
      i2 shouldBe IntervalClass.WholeTone
    }
  }
}
