package com.dycjan.domain

import cats.Show

case class Value(v: Int) extends AnyVal

object Value {
  implicit val valueShow = new Show[Value] {
    override def show(t: Value): String = t.v.toString
  }
}

case class Triangle(values: List[List[Value]])

object Triangle {
  implicit val triangleShow = new Show[Triangle] {
    override def show(t: Triangle): String =
      t.values.map(v => v.map(_.v).mkString(" ")).mkString("\n")
  }

}
