package com.github.damiox.computerscience.exercises.math;

import org.junit.Assert;
import org.junit.Test;

public class CheckBinaryAndHexMatchExerciseTest {

    @Test
    public void testSolve() {
        Assert.assertTrue(new CheckBinaryAndHexMatchExercise().solve(new CheckBinaryAndHexMatchExercise.Params("100", "4")));
        Assert.assertTrue(new CheckBinaryAndHexMatchExercise().solve(new CheckBinaryAndHexMatchExercise.Params("0", "0")));
        Assert.assertTrue(new CheckBinaryAndHexMatchExercise().solve(new CheckBinaryAndHexMatchExercise.Params("11", "3")));
        Assert.assertTrue(new CheckBinaryAndHexMatchExercise().solve(new CheckBinaryAndHexMatchExercise.Params("10000", "10")));
        Assert.assertTrue(new CheckBinaryAndHexMatchExercise().solve(new CheckBinaryAndHexMatchExercise.Params("1111", "F")));
        Assert.assertFalse(new CheckBinaryAndHexMatchExercise().solve(new CheckBinaryAndHexMatchExercise.Params("1000", "FFFF")));
    }

}
