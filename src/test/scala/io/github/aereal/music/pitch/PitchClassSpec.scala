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
  }
}
