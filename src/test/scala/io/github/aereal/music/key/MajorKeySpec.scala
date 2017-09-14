package io
package github
package aereal
package music
package key

import pitch.PitchClass

class MajorKeySpec extends BaseSpec {
  describe("MajorKey") {
    describe("tones") {
      it("returns all tones of the key") {
        import PitchClass._

        val cMajor = MajorKey(C)
        cMajor.tones shouldBe Seq(C, D, E, F, G, A, H)

        val dMajor = MajorKey(D)
        dMajor.tones shouldBe Seq(D, E, Fis, G, A, H, Cis)
      }
    }
  }
}
