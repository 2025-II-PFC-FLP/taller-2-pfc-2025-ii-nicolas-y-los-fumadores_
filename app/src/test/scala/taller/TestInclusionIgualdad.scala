package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

import taller.InclusionIgualdad.inclusion
import taller.InclusionIgualdad.igualdad

@RunWith(classOf[JUnitRunner])
class InclusionIgualdadTest extends AnyFunSuite {

  // --- Pruebas triviales ---
  test("[Trivial] Todo conjunto está incluido en sí mismo") {
    val conj1: ConjDifuso = (elem: Int) => if (elem >= 0 && elem <= 1000) 0.5 else 0.0
    assert(inclusion(conj1, conj1))
  }

  test("[Trivial] Conjunto con grados menores está incluido en conjunto con grados mayores") {
    val conjMenor: ConjDifuso = (elem: Int) => if (elem >= 0 && elem <= 1000) 0.3 else 0.0
    val conjMayor: ConjDifuso = (elem: Int) => if (elem >= 0 && elem <= 1000) 0.7 else 0.0

    assert(inclusion(conjMenor, conjMayor))
  }

  test("[Trivial] Conjunto vacío está incluido en cualquier conjunto") {
    val conjVacio: ConjDifuso = (elem: Int) => 0.0
    val conjCualquiera: ConjDifuso = (elem: Int) => if (elem >= 0 && elem <= 1000) 0.5 else 0.0

    assert(inclusion(conjVacio, conjCualquiera))
  }

  test("[Trivial] Todo conjunto es igual a sí mismo") {
    val conj1: ConjDifuso = (elem: Int) => if (elem >= 0 && elem <= 1000) 0.5 else 0.0
    assert(igualdad(conj1, conj1))
  }

  test("[Trivial] Dos conjuntos constantes con mismo valor son iguales") {
    val conj1: ConjDifuso = (elem: Int) => if (elem >= 0 && elem <= 1000) 0.5 else 0.0
    val conj2: ConjDifuso = (elem: Int) => if (elem >= 0 && elem <= 1000) 0.5 else 0.0

    assert(igualdad(conj1, conj2))
  }

  test("[Trivial] Conjunto con grados mayores NO está incluido en conjunto con grados menores") {
    val conjMenor: ConjDifuso = (elem: Int) => if (elem >= 0 && elem <= 1000) 0.3 else 0.0
    val conjMayor: ConjDifuso = (elem: Int) => if (elem >= 0 && elem <= 1000) 0.7 else 0.0

    assert(!inclusion(conjMayor, conjMenor))
  }

  test("[Trivial] Dos conjuntos con valores diferentes NO son iguales") {
    val conj1: ConjDifuso = (elem: Int) => if (elem >= 0 && elem <= 1000) 0.3 else 0.0
    val conj2: ConjDifuso = (elem: Int) => if (elem >= 0 && elem <= 1000) 0.7 else 0.0

    assert(!igualdad(conj1, conj2))
  }

  test("[Trivial] Conjunto completo incluye a cualquier otro conjunto") {
    val conjCompleto: ConjDifuso = (elem: Int) => if (elem >= 0 && elem <= 1000) 1.0 else 0.0
    val conjCualquiera: ConjDifuso = (elem: Int) => if (elem >= 0 && elem <= 1000) 0.5 else 0.0

    assert(inclusion(conjCualquiera, conjCompleto))
  }

  test("[Trivial] Inclusión con conjuntos de un solo valor diferente") {
    val conj1: ConjDifuso = (elem: Int) => if (elem == 500) 0.4 else 0.0
    val conj2: ConjDifuso = (elem: Int) => if (elem == 500) 0.8 else 0.0

    assert(inclusion(conj1, conj2))
  }

  test("[Trivial] Igualdad entre dos conjuntos vacíos") {
    val conjVacio1: ConjDifuso = (elem: Int) => 0.0
    val conjVacio2: ConjDifuso = (elem: Int) => 0.0

    assert(igualdad(conjVacio1, conjVacio2))
  }

}


