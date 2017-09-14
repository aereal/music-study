package io
package github
package aereal
package music

import org.scalatest.FunSpec
import org.scalatest.Inside
import org.scalatest.Inspectors
import org.scalatest.Matchers
import org.scalatest.OptionValues

abstract class BaseSpec
    extends FunSpec
    with Matchers
    with Inside
    with Inspectors
    with OptionValues
