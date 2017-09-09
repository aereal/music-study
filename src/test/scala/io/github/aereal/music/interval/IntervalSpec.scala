package io
package github
package aereal
package music
package interval

class IntervalSpec extends BaseSpec {
  describe("Interval") {
    describe("semiTones") {
      it("is 0 if unison") {
        Interval.Unison.semiTones shouldBe 0
      }

      it("is 12 if octave") {
        Interval.Octave.semiTones shouldBe 12
      }

      it("is 1 if minor second or augmented unison") {
        val m2 = Interval(Number(2), Quality.Minor)
        val a1 = Interval(Number(1), Quality.Augmented)
        m2.semiTones shouldBe 1
        a1.semiTones shouldBe 1
      }

      it("is 2 if major second or diminished third") {
        val M2 = Interval(Number(2), Quality.Major)
        val d3 = Interval(Number(3), Quality.Diminished)
        M2.semiTones shouldBe 2
        d3.semiTones shouldBe 2
      }
    }
  }
}
