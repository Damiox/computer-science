package com.github.damiox.computerscience.exercises.string;

import org.junit.Assert;
import org.junit.Test;

public class StringContainsPermutedPatternExerciseTest {

    @Test
    public void testSolve() {
        Assert.assertEquals(2, (long)new StringContainsPermutedPatternExercise().solve(new StringContainsPermutedPatternExercise.Params("mandioca", "dni")).get(0));
        Assert.assertEquals(0, (long)new StringContainsPermutedPatternExercise().solve(new StringContainsPermutedPatternExercise.Params("dni mio es el mejor dni", "dni")).get(0));
        Assert.assertEquals(20, (long)new StringContainsPermutedPatternExercise().solve(new StringContainsPermutedPatternExercise.Params("dni mio es el mejor dni", "dni")).get(1));
    }

}
