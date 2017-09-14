package io
package github
package aereal
package music
package web
package controllers

import javax.inject.Inject
import javax.inject.Singleton

import key.Key
import key.MajorKey
import key.MinorKey
import pitch.PitchClass
import play.api.libs.json.JsError
import play.api.libs.json.JsSuccess
import play.api.libs.json.Json
import play.api.libs.json.Reads
import play.api.mvc.AbstractController
import play.api.mvc.ControllerComponents
import generator.HarmonyGenerator
import play.api.libs.json.Writes
import chord.Chord

@Singleton
class GenerationController @Inject()(cc: ControllerComponents)
    extends AbstractController(cc) {
  implicit val readsKey: Reads[Key] = Reads(
    value =>
      value
        .validate[String]
        .flatMap(str => {
          str.split(" ").toList match {
            case center :: major :: Nil if major == "major" =>
              PitchClass.from(center) match {
                case Some(pc) => JsSuccess(MajorKey(pc))
                case None => JsError("Unknown pitch class")
              }
            case center :: minor :: Nil if minor == "minor" =>
              PitchClass.from(center) match {
                case Some(pc) => JsSuccess(MinorKey(pc))
                case None => JsError("Unknown pitch class")
              }
            case _ => JsError("Unknown key")
          }
        }))

  implicit val writesTriadChord: Writes[Chord.Triad] = Writes(c => {
    Json.arr(c.root.label, c.third.label, c.fifth.label)
  })

  case class GenerationParams(key: Key, bars: Int)
  object GenerationParams {
    implicit val reads: Reads[GenerationParams] = Json.reads[GenerationParams]
  }

  private def generateHarmony(count: Int,
                              accum: Seq[Chord],
                              harmonyGenerator: HarmonyGenerator): Seq[Chord] =
    count match {
      case 0 => accum
      case current =>
        val (chord, movedGen) = harmonyGenerator.generate()
        generateHarmony(current - 1, accum :+ chord, movedGen)
    }

  def generate() = Action(cc.parsers.json) { implicit request =>
    request.body.validate[GenerationParams].asEither match {
      case Right(params) =>
        val chords =
          generateHarmony(params.bars, Seq.empty, HarmonyGenerator(params.key))
        Ok(
          Json.obj("ok" -> true,
                   "chords" -> chords.map(_.asInstanceOf[Chord.Triad])))
      case Left(_) =>
        BadRequest(Json.obj("error" -> "Invalid request parameters"))
    }
  }
}
