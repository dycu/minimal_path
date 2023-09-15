package com.dycjan.domain

import cats.Show

case class Value(v: Int) extends AnyVal

object Value {
  implicit val valueShow = new Show[Value] {
    override def show(t: Value): String = t.v.toString
  }
}

trait BinaryTree
case class Node(value: Value, l: BinaryTree, r: BinaryTree) extends BinaryTree
case class Leaf(value: Value) extends BinaryTree

object BinaryTree {
  implicit val binaryTreeShow = new Show[BinaryTree] {
    override def show(t: BinaryTree): String = t match {
      case Node(v, l, r) => s"(${show(l)}, ${Show[Value].show(v)}, ${show(r)})"
      case Leaf(v) => Show[Value].show(v)

    }
  }
}

