package io
package github
package aereal
package music
package web
package controllers

import javax.inject.Singleton
import javax.inject.Inject

import play.api.mvc.AbstractController
import play.api.mvc.ControllerComponents

@Singleton
class RootController @Inject()(cc: ControllerComponents)
    extends AbstractController(cc) {
  def index() = Action { _ =>
    Ok("ok")
  }
}
