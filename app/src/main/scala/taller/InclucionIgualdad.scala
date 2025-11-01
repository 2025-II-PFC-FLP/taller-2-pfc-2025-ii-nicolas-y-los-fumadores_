package taller

import scala.annotation.tailrec

object InclusionIgualdad {
  
  type ConjDifuso = Int => Double

  // Inclusión usando recursión de cola
  def inclusion(cd1: ConjDifuso, cd2: ConjDifuso): Boolean = {
    @tailrec
    def verificarInclusion(n: Int): Boolean = {
      if (n > 1000)
        true
      else if (cd1(n) > cd2(n))
        false
      else
        verificarInclusion(n + 1)
    }
    verificarInclusion(0)
  }

  def igualdad(cd1: ConjDifuso, cd2: ConjDifuso): Boolean =
    inclusion(cd1, cd2) && inclusion(cd2, cd1)
}
