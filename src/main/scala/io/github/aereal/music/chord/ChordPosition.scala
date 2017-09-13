package io
package github
package aereal
package music
package chord

sealed trait ChordPosition
object ChordPosition {
  case object I extends ChordPosition
  case object II extends ChordPosition
  case object III extends ChordPosition
  case object IV extends ChordPosition
  case object V extends ChordPosition
  case object VI extends ChordPosition
  case object VII extends ChordPosition
}
