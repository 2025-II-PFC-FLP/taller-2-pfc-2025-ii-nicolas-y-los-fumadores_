package taller

import scala.annotation.tailrec

abstract class ConjDifuso {
  def pertenece(elem: Int): Double
}

object InclusionIgualdad {

  // Inclusión usando recursión de cola
  def inclusion(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
    @tailrec
    def verificarInclusion(n: Int): Boolean = {
      if (n > 1000)
        true
      else if (cd1.pertenece(n) > cd2.pertenece(n))
        false
      else
        verificarInclusion(n + 1)
    }
    verificarInclusion(0)
  }

  def igualdad(cd1: ConjDifuso, cd2: ConjDifuso): Boolean =
    inclusion(cd1, cd2) && inclusion(cd2, cd1)
}