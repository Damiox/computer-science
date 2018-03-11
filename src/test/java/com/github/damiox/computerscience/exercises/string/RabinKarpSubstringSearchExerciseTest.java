package com.github.damiox.computerscience.exercises.string;

import org.junit.Assert;
import org.junit.Test;

public class RabinKarpSubstringSearchExerciseTest {

    @Test
    public void testSolve() {
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(new String[] { "rap", "DADrapDAD" }));
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(new String[] { "rap", "rapDAD" }));
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(new String[] { "rap", "DADrap" }));
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(new String[] { "rap", "DADraaaprapDAD" }));
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(new String[] { "rap", "rap" }));
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(new String[] { "aaa", "xxaaaxx" }));
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(new String[] { "aaa", "aaa" }));
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(new String[] { "aaa", "aaaa" }));
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(new String[] { "aaa", "aaaxx" }));
        Assert.assertFalse(new RabinKarpSubstringSearchExercise().solve(new String[] { "rap", "DADRap" }));
        Assert.assertFalse(new RabinKarpSubstringSearchExercise().solve(new String[] { "rap", "ra3p" }));
        Assert.assertFalse(new RabinKarpSubstringSearchExercise().solve(new String[] { "rap", "par" }));
        Assert.assertFalse(new RabinKarpSubstringSearchExercise().solve(new String[] { "aaa", "aaA" }));
    }

}
