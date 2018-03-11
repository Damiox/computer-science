package com.github.damiox.computerscience.exercises.math;

import com.github.damiox.computerscience.Exercise;
import com.github.damiox.computerscience.exercises.math.TaxicabNumberExercise;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class TaxicabNumberExerciseTest {

    @Test
    public void testSolve() {
        final int n = 1000;

        Map<Long, List<TaxicabNumberExercise.Pair>> results =
            new TaxicabNumberExercise().solve(n);

        Assert.assertEquals(1585, results.size());
        Assert.assertNotNull(results.get(206471727L));
        Assert.assertNotNull(results.get(61555832L));

        Assert.assertEquals(206471727L * 2,
            testTaxicabNumber(
                results.get(206471727L).get(0).i,
                results.get(206471727L).get(0).j,
                results.get(206471727L).get(1).i,
                results.get(206471727L).get(1).j
            )
        );

        Assert.assertEquals(61555832L * 2,
            testTaxicabNumber(
                results.get(61555832L).get(0).i,
                results.get(61555832L).get(0).j,
                results.get(61555832L).get(1).i,
                results.get(61555832L).get(1).j
            )
        );

        Assert.assertFalse(
            results.values().stream()
                .flatMap(List::stream)
                .anyMatch(r -> r.i > n || r.j > n)
        );
    }

    private long testTaxicabNumber(int a, int b, int c, int d) {
        return (long)(Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) + Math.pow(d, 3));
    }

}
