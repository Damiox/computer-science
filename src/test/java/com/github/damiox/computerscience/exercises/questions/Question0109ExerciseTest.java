package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

public class Question0109ExerciseTest {

    @Test
    public void testSolve() {
        Assert.assertTrue(new Question0109Exercise().solve(new Question0109Exercise.Params("a".toCharArray(), "a".toCharArray())));
        Assert.assertTrue(new Question0109Exercise().solve(new Question0109Exercise.Params("ab".toCharArray(), "ba".toCharArray())));
        Assert.assertTrue(new Question0109Exercise().solve(new Question0109Exercise.Params("waterbottle".toCharArray(), "erbottlewat".toCharArray())));
        Assert.assertFalse(new Question0109Exercise().solve(new Question0109Exercise.Params("a".toCharArray(), "b".toCharArray())));
        Assert.assertFalse(new Question0109Exercise().solve(new Question0109Exercise.Params("abc".toCharArray(), "bac".toCharArray())));
        Assert.assertFalse(new Question0109Exercise().solve(new Question0109Exercise.Params("waterbottle".toCharArray(), "erbotlewat".toCharArray())));
    }

}
