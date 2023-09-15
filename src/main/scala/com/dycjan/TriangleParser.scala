package com.dycjan

import com.dycjan.domain.{Triangle, Value}

/** It's going to parse the input which is in form of line of strings
  * into proper data structure.
  */
class TriangleParser {

  def parseInput(lines: List[String]): Triangle =
    Triangle(lines.map(line => line.split(" ").toList.map(i => Value(i.toInt))))

}
