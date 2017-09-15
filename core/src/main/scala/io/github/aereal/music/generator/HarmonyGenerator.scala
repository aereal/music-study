package io
package github
package aereal
package music
package generator

import key.Key
import chord.Chord

class HarmonyGenerator protected (val key: Key, chordGenerator: ChordGenerator) {
  def generate(): (Chord, HarmonyGenerator) = {
    val (nextChordPosition, movedChordGenerator) = chordGenerator.generate()
    val nextChord = Chord.Triad.from(key, nextChordPosition)
    (nextChord, new HarmonyGenerator(key, movedChordGenerator))
  }
}
object HarmonyGenerator {
  def apply(key: Key): HarmonyGenerator =
    new HarmonyGenerator(key, ChordGenerator())
}
