package io
package github
package aereal
package music
package types
package syntax

import scala.language.implicitConversions

trait EqSyntax {
  implicit def eqSyntaxOps[A: Eq](a: A): EqOps[A] = new EqOps[A](a)
}
object EqSyntax extends EqSyntax

class EqOps[A: Eq](val lhs: A) {
  def ===(rhs: A): Boolean = implicitly[Eq[A]].eqv(lhs, rhs)

  def =!=(rhs: A): Boolean = implicitly[Eq[A]].neqv(lhs, rhs)
}
