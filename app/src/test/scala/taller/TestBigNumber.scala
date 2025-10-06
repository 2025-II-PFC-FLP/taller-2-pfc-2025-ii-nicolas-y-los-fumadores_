package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BigNumberTest extends AnyFunSuite {
  val bigNumber = new BigNumber()

  // --- Pruebas triviales ---
  test("[Trivial] Números negativos y cero deben retornar 0.0") {
    val conjGrande = bigNumber.grande(5, 2)
    assert(conjGrande(-5) == 0.0)
    assert(conjGrande(0) == 0.0)
  }

  test("[Trivial] Con d=1, e=1, número 1 debe dar 0.5") {
    val conjGrande = bigNumber.grande(1, 1)
    val resultado = conjGrande(1)
    assert(math.abs(resultado - 0.5) < 0.001) // 1/(1+1) = 0.5
  }

  test("[Trivial] Números más grandes dan mayor grado de pertenencia") {
    val conjGrande = bigNumber.grande(5, 2)
    val grado10 = conjGrande(10)
    val grado50 = conjGrande(50)

    assert(grado50 > grado10)
  }

  // --- Pruebas de comportamiento ---
  test("[Comportamiento] Función debe ser creciente") {
    val conjGrande = bigNumber.grande(5, 2)
    val grados = List(1, 10, 20, 50).map(conjGrande)

    for (i <- 1 until grados.length) {
      assert(grados(i) >= grados(i-1))
    }
  }

  test("[Comportamiento] Parámetro d afecta el resultado") {
    val conjSuave = bigNumber.grande(1, 2)
    val conjDuro = bigNumber.grande(10, 2)

    assert(conjSuave(10) > conjDuro(10))
  }

  // --- Pruebas de valores específicos ---
  test("[Específico] Con d=1, e=2, verificar cálculos conocidos") {
    val conjGrande = bigNumber.grande(1, 2)

    val grado1 = conjGrande(1)  // (1/2)^2 = 0.25
    val grado3 = conjGrande(3)  // (3/4)^2 = 0.5625

    assert(math.abs(grado1 - 0.25) < 0.001)
    assert(math.abs(grado3 - 0.5625) < 0.001)
  }

  test("[Específico] Resultados siempre entre 0 y 1") {
    val conjGrande = bigNumber.grande(5, 3)
    val valores = List(1, 5, 10, 25, 100)

    valores.foreach { n =>
      val grado = conjGrande(n)
      assert(grado >= 0.0 && grado <= 1.0)
    }
  }
}
