package taller

import org.scalatest.funsuite.AnyFunSuite

class ConjDifusoOpsTest extends AnyFunSuite {

  test("Complemento") {
    val c1: Int => Double = _ => 0.0
    val comp1: Int => Double = x => 1.0 - c1(x)
    assert(math.abs(comp1(5) - 1.0) < 0.0001)

    val c2: Int => Double = _ => 1.0
    val comp2: Int => Double = x => 1.0 - c2(x)
    assert(math.abs(comp2(10) - 0.0) < 0.0001)

    val c3: Int => Double = _ => 0.5
    val comp3: Int => Double = x => 1.0 - c3(x)
    assert(math.abs(comp3(3) - 0.5) < 0.0001)

    val c4: Int => Double = x => x / 10.0
    val comp4: Int => Double = x => 1.0 - c4(x)
    assert(math.abs(comp4(2) - 0.8) < 0.0001)

    val c5: Int => Double = _ => 0.9
    val comp5: Int => Double = x => 1.0 - c5(x)
    assert(math.abs(comp5(7) - 0.1) < 0.0001)
  }

  test("Unión") {
    val c1: Int => Double = _ => 0.0
    val c2: Int => Double = _ => 0.5
    val u1: Int => Double = x => math.max(c1(x), c2(x))
    assert(math.abs(u1(4) - 0.5) < 0.0001)

    val c3: Int => Double = _ => 1.0
    val c4: Int => Double = _ => 0.3
    val u2: Int => Double = x => math.max(c3(x), c4(x))
    assert(math.abs(u2(6) - 1.0) < 0.0001)

    val c5: Int => Double = _ => 0.4
    val c6: Int => Double = _ => 0.4
    val u3: Int => Double = x => math.max(c5(x), c6(x))
    assert(math.abs(u3(2) - 0.4) < 0.0001)

    val c7: Int => Double = x => x / 10.0
    val c8: Int => Double = x => (10 - x) / 10.0
    val u4: Int => Double = x => math.max(c7(x), c8(x))
    assert(math.abs(u4(2) - 0.8) < 0.0001)

    val c9: Int => Double = _ => 0.9
    val c10: Int => Double = _ => 0.1
    val u5: Int => Double = x => math.max(c9(x), c10(x))
    assert(math.abs(u5(9) - 0.9) < 0.0001)
  }

  test("Intersección") {
    val c1: Int => Double = _ => 0.0
    val c2: Int => Double = _ => 0.7
    val i1: Int => Double = x => math.min(c1(x), c2(x))
    assert(math.abs(i1(1) - 0.0) < 0.0001)

    val c3: Int => Double = _ => 1.0
    val c4: Int => Double = _ => 0.6
    val i2: Int => Double = x => math.min(c3(x), c4(x))
    assert(math.abs(i2(8) - 0.6) < 0.0001)

    val c5: Int => Double = _ => 0.5
    val c6: Int => Double = _ => 0.5
    val i3: Int => Double = x => math.min(c5(x), c6(x))
    assert(math.abs(i3(3) - 0.5) < 0.0001)

    val c7: Int => Double = x => x / 10.0
    val c8: Int => Double = x => (10 - x) / 10.0
    val i4: Int => Double = x => math.min(c7(x), c8(x))
    assert(math.abs(i4(8) - 0.2) < 0.0001)

    val c9: Int => Double = _ => 0.9
    val c10: Int => Double = _ => 0.1
    val i5: Int => Double = x => math.min(c9(x), c10(x))
    assert(math.abs(i5(5) - 0.1) < 0.0001)
  }
}
