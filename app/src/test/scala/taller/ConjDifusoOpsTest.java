package taller;

import junit.framework.TestCase;
import java.util.function.Function;

public class ConjDifusoOpsTest extends TestCase {

    public void testComplemento() {
        // 1: complemento de 0 -> 1
        Function<Integer, Double> c1 = x -> 0.0;
        Function<Integer, Double> comp1 = x -> 1.0 - c1.apply(x);
        assertEquals(1.0, comp1.apply(5), 0.0001);

        // 2: complemento de 1 -> 0
        Function<Integer, Double> c2 = x -> 1.0;
        Function<Integer, Double> comp2 = x -> 1.0 - c2.apply(x);
        assertEquals(0.0, comp2.apply(10), 0.0001);

        // 3: complemento de 0.5 -> 0.5
        Function<Integer, Double> c3 = x -> 0.5;
        Function<Integer, Double> comp3 = x -> 1.0 - c3.apply(x);
        assertEquals(0.5, comp3.apply(3), 0.0001);

        // 4: función dependiente de x
        Function<Integer, Double> c4 = x -> x / 10.0;
        Function<Integer, Double> comp4 = x -> 1.0 - c4.apply(x);
        assertEquals(0.8, comp4.apply(2), 0.0001);

        // 5: valor cercano a 1
        Function<Integer, Double> c5 = x -> 0.9;
        Function<Integer, Double> comp5 = x -> 1.0 - c5.apply(x);
        assertEquals(0.1, comp5.apply(7), 0.0001);
    }

    public void testUnion() {
        // 1: unión de 0 y 0.5 -> 0.5
        Function<Integer, Double> c1 = x -> 0.0;
        Function<Integer, Double> c2 = x -> 0.5;
        Function<Integer, Double> u1 = x -> Math.max(c1.apply(x), c2.apply(x));
        assertEquals(0.5, u1.apply(4), 0.0001);

        // 2: unión de 1 y 0.3 -> 1
        Function<Integer, Double> c3 = x -> 1.0;
        Function<Integer, Double> c4 = x -> 0.3;
        Function<Integer, Double> u2 = x -> Math.max(c3.apply(x), c4.apply(x));
        assertEquals(1.0, u2.apply(6), 0.0001);

        // 3: unión de iguales 0.4 -> 0.4
        Function<Integer, Double> c5 = x -> 0.4;
        Function<Integer, Double> c6 = x -> 0.4;
        Function<Integer, Double> u3 = x -> Math.max(c5.apply(x), c6.apply(x));
        assertEquals(0.4, u3.apply(2), 0.0001);

        // 4: unión con funciones complementarias
        Function<Integer, Double> c7 = x -> x / 10.0;
        Function<Integer, Double> c8 = x -> (10 - x) / 10.0;
        Function<Integer, Double> u4 = x -> Math.max(c7.apply(x), c8.apply(x));
        assertEquals(0.8, u4.apply(2), 0.0001);

        // 5: unión de 0.9 y 0.1 -> 0.9
        Function<Integer, Double> c9 = x -> 0.9;
        Function<Integer, Double> c10 = x -> 0.1;
        Function<Integer, Double> u5 = x -> Math.max(c9.apply(x), c10.apply(x));
        assertEquals(0.9, u5.apply(9), 0.0001);
    }

    public void testInterseccion() {
        // 1: intersección de 0 y 0.7 -> 0
        Function<Integer, Double> c1 = x -> 0.0;
        Function<Integer, Double> c2 = x -> 0.7;
        Function<Integer, Double> i1 = x -> Math.min(c1.apply(x), c2.apply(x));
        assertEquals(0.0, i1.apply(1), 0.0001);

        // 2: intersección de 1 y 0.6 -> 0.6
        Function<Integer, Double> c3 = x -> 1.0;
        Function<Integer, Double> c4 = x -> 0.6;
        Function<Integer, Double> i2 = x -> Math.min(c3.apply(x), c4.apply(x));
        assertEquals(0.6, i2.apply(8), 0.0001);

        // 3: intersección de iguales 0.5 -> 0.5
        Function<Integer, Double> c5 = x -> 0.5;
        Function<Integer, Double> c6 = x -> 0.5;
        Function<Integer, Double> i3 = x -> Math.min(c5.apply(x), c6.apply(x));
        assertEquals(0.5, i3.apply(3), 0.0001);

        // 4: intersección con funciones complementarias
        Function<Integer, Double> c7 = x -> x / 10.0;
        Function<Integer, Double> c8 = x -> (10 - x) / 10.0;
        Function<Integer, Double> i4 = x -> Math.min(c7.apply(x), c8.apply(x));
        assertEquals(0.2, i4.apply(8), 0.0001);

        // 5: intersección de 0.9 y 0.1 -> 0.1
        Function<Integer, Double> c9 = x -> 0.9;
        Function<Integer, Double> c10 = x -> 0.1;
        Function<Integer, Double> i5 = x -> Math.min(c9.apply(x), c10.apply(x));
        assertEquals(0.1, i5.apply(5), 0.0001);
    }
}
