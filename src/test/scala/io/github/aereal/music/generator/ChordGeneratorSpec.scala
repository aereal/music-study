package io
package github
package aereal
package music
package generator

class ChordGeneratorSpec extends BaseSpec {
  describe("ChordGenerator") {
    it("generates next chord position based on current position") {
      import chord.ChordPosition._

      val gen = ChordGenerator()
      gen.isStarted shouldBe false
      gen.reversedChordsQueue shouldBe Nil
      gen.candidates shouldBe Set(I, IV, V)
      val (nextCode, gen2) = gen.generate()
      Set(I, IV, V) should contain(nextCode)
    }
  }
}
