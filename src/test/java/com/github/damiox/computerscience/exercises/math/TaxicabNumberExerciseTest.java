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

        Exercise.Results<Map<Long, List<TaxicabNumberExercise.Pair>>> results =
            new TaxicabNumberExercise().solve(() -> n);

        Assert.assertEquals(1585, results.getResults().size());
        Assert.assertNotNull(results.getResults().get(206471727L));
        Assert.assertNotNull(results.getResults().get(61555832L));

        Assert.assertEquals(206471727L * 2,
            testTaxicabNumber(
                results.getResults().get(206471727L).get(0).i,
                results.getResults().get(206471727L).get(0).j,
                results.getResults().get(206471727L).get(1).i,
                results.getResults().get(206471727L).get(1).j
            )
        );

        Assert.assertEquals(61555832L * 2,
            testTaxicabNumber(
                results.getResults().get(61555832L).get(0).i,
                results.getResults().get(61555832L).get(0).j,
                results.getResults().get(61555832L).get(1).i,
                results.getResults().get(61555832L).get(1).j
            )
        );

        Assert.assertFalse(
            results.getResults().values().stream()
                .flatMap(List::stream)
                .anyMatch(r -> r.i > n || r.j > n)
        );
    }

    private long testTaxicabNumber(int a, int b, int c, int d) {
        return (long)(Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3) + Math.pow(d, 3));
    }

}
