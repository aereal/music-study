package io
package github
package aereal
package music
package chord

sealed abstract class ChordPosition(val offset: Int)
object ChordPosition {
  case object I extends ChordPosition(0)
  case object II extends ChordPosition(1)
  case object III extends ChordPosition(2)
  case object IV extends ChordPosition(3)
  case object V extends ChordPosition(4)
  case object VI extends ChordPosition(5)
  case object VII extends ChordPosition(6)
}
