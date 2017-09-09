package io
package github
package aereal
package music
package interval

class NumberSpec extends BaseSpec {
  describe("Number") {
    it("Number(1) + Number(1)") {
      val n = Number(1) + Number(1)
      n shouldBe Number(2)
    }

    it("Number(3) + Number(4)") {
      val n = Number(3) + Number(4)
      n shouldBe Number(6)
    }

    it("Number(3) - Number(2)") {
      val n = Number(3) - Number(2)
      n shouldBe Number(1)
    }

    it("Number(3) - Number(1)") {
      val n = Number(3) - Number(1)
      n shouldBe Number(2)
    }

    it("Number(1) - Number(1)") {
      val n = Number(1) - Number(1)
      n shouldBe Number(7)
    }

    it("Number(1) - Number(2)") {
      val n = Number(1) - Number(2)
      n shouldBe Number(6)
    }
  }
}
