package io
package github
package aereal
package music
package generator

import key.MajorKey
import pitch.PitchClass

class HarmonyGeneratorSpec extends BaseSpec {
  describe("HarmonyGenerator") {
    it("generates concrete chord based on the key") {
      val gen = HarmonyGenerator(MajorKey(PitchClass.C))
      val (chord, gen2) = gen.generate()
    }
  }
}
