package taller

class BigNumber {
  type ConjDifuso = Int => Double
  def grande(d: Int, e: Int): ConjDifuso = {

    def potencia(b: Double, exp: Int, acc: Double): Double = {
      if (exp == 0) acc
      else {
        potencia(b, exp - 1, acc * b)
      }
    }

    def funcionGradoPertenencia(n: Int): Double = {
        if (n <= 0) {
          0.0

        } else {
          val base = n.toDouble / (n + d)
          // Calcular base = n / (n + d)
          potencia(base, e, 1)

        }
      }
      funcionGradoPertenencia
    }
}

