package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

public class Question0101ExerciseTest {

    @Test
    public void testSolve() {
        // testing uniques
        Assert.assertTrue(new Question0101Exercise().solve("ABCDEFGabcdefg"));
        Assert.assertTrue(new Question0101Exercise().solve("ABCDEFG0123io[]:,\"'"));
        Assert.assertTrue(new Question0101Exercise().solve("123ABC456DEF7890GHIJ.,<>[]{}"));
        // testing non uniques
        Assert.assertFalse(new Question0101Exercise().solve("ABCDEFA"));
        Assert.assertFalse(new Question0101Exercise().solve("123123"));
        Assert.assertFalse(new Question0101Exercise().solve("OK. Sure."));
    }

}
