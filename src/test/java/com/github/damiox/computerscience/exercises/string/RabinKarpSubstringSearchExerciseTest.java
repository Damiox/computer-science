package com.github.damiox.computerscience.exercises.string;

import org.junit.Assert;
import org.junit.Test;

public class RabinKarpSubstringSearchExerciseTest {

    @Test
    public void testSolve() {
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(() -> new String[] { "rap", "DADrapDAD" }).getResults());
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(() -> new String[] { "rap", "rapDAD" }).getResults());
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(() -> new String[] { "rap", "DADrap" }).getResults());
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(() -> new String[] { "rap", "DADraaaprapDAD" }).getResults());
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(() -> new String[] { "rap", "rap" }).getResults());
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(() -> new String[] { "aaa", "xxaaaxx" }).getResults());
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(() -> new String[] { "aaa", "aaa" }).getResults());
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(() -> new String[] { "aaa", "aaaa" }).getResults());
        Assert.assertTrue(new RabinKarpSubstringSearchExercise().solve(() -> new String[] { "aaa", "aaaxx" }).getResults());
        Assert.assertFalse(new RabinKarpSubstringSearchExercise().solve(() -> new String[] { "rap", "DADRap" }).getResults());
        Assert.assertFalse(new RabinKarpSubstringSearchExercise().solve(() -> new String[] { "rap", "ra3p" }).getResults());
        Assert.assertFalse(new RabinKarpSubstringSearchExercise().solve(() -> new String[] { "rap", "par" }).getResults());
        Assert.assertFalse(new RabinKarpSubstringSearchExercise().solve(() -> new String[] { "aaa", "aaA" }).getResults());
    }

}
