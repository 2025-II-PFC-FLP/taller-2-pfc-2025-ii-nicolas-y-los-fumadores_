package taller

class BuscarLista() {
  def buscarElemento(lista: List[Int], elemento: Int): Boolean = {
  lista match {
    case Nil => false
    case x :: xs => if (x == elemento) true else buscarElemento(xs, elemento)
   }
  }
}

// ----------------------------------------------------------------------------------------------------------
object ConjDifusoOps {
  type ConjDifuso = Int => Double
  def complemento(c: ConjDifuso): ConjDifuso = (x: Int) => 1.0 - c(x)
  def union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = (x: Int) => math.max(cd1(x), cd2(x))
  def interseccion(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = (x: Int) => math.min(cd1(x), cd2(x))
}
// ----------------------------------------------------------------------------------------------------------
