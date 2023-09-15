package com.dycjan.domain

trait BinaryTree
case class Node(value: Int, l: BinaryTree, r: BinaryTree) extends BinaryTree
case class Leaf(value: Int) extends BinaryTree

