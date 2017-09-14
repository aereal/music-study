package io
package github
package aereal
package music
package chord

import pitch.PitchClass

class ChordSpec extends BaseSpec {
  describe("Chord") {
    import PitchClass._
    val other = Chord.Triad(C, D, E)
    val majorC = Chord.Triad(C, E, G)
    val minorC = Chord.Triad(C, Es, G)

    it("has equality") {
      majorC shouldBe Chord.Triad(C, E, G)
      majorC shouldNot be(minorC)
    }

    it("is major if interval of third tone and root tone is major third") {
      majorC.isMajor shouldBe true
      minorC.isMajor shouldBe false
      other.isMajor shouldBe false
    }

    it("is minor if interval of third tone and root tone is minor third") {
      majorC.isMinor shouldBe false
      minorC.isMinor shouldBe true
      other.isMinor shouldBe false
    }

    it("is triad if the chord has correct intervals") {
      majorC.isTriad shouldBe true
      minorC.isTriad shouldBe true
      other.isTriad shouldBe false
    }

    describe("Chord.Triad") {
      it("can be built from the root tone and #major method") {
        val c = Chord.Triad.major(C)
        c shouldBe Chord.Triad(C, E, G)
      }

      it("can be built from the root tone and #minor method") {
        val c = Chord.Triad.minor(C)
        c shouldBe Chord.Triad(C, Es, G)
      }
    }
  }
}
