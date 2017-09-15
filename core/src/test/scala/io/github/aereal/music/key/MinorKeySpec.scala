package io
package github
package aereal
package music
package key

import pitch.PitchClass

class MinorKeySpec extends BaseSpec {
  describe("MinorKey") {
    describe("tones") {
      it("returns all tones of the key") {
        import PitchClass._

        val cMinor = MinorKey(C)
        cMinor.tones shouldBe Seq(C, D, Es, F, G, As, B)

        val dMinor = MinorKey(D)
        dMinor.tones shouldBe Seq(D, E, F, G, A, B, C)
      }
    }
  }
}
