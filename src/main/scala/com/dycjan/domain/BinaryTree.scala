package com.dycjan.domain

case class Value(v: Int) extends AnyVal

trait BinaryTree
case class Node(value: Value, l: BinaryTree, r: BinaryTree) extends BinaryTree
case class Leaf(value: Value) extends BinaryTree

