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

    it("has equality") {
      PitchClass.C shouldBe PitchClass.C
      PitchClass.C shouldNot be(PitchClass.Cis)
    }

    it("has a difference between other pitch class") {
      val i1 = PitchClass.C.intervalOf(PitchClass.C)
      i1 shouldBe IntervalClass.Same

      val i2 = PitchClass.D.intervalOf(PitchClass.C)
      i2 shouldBe IntervalClass.WholeTone
    }

    describe("+") {
      it("returns PitchClass that forwarded given interval") {
        val p1 = PitchClass.C + IntervalClass.WholeTone
        p1 shouldBe PitchClass.D

        val p2 = PitchClass.H + IntervalClass.HalfTone
        p2 shouldBe PitchClass.C
      }
    }
  }
}
