package com.dycjan.domain

/** Used to remember traversed path while going through the tree
  */
trait Step
object Step {
  case object LeftStep extends Step
  case object RightStep extends Step
}
