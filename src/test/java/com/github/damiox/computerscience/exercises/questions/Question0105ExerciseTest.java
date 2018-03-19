package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

public class Question0105ExerciseTest {

    @Test
    public void testSolve() {
        Assert.assertTrue(new Question0105Exercise().solve(new Question0105Exercise.Params(new char[] { 'p', 'a', 'l', 'e' }, new char[] { 'p', 'l', 'e' })));
        Assert.assertTrue(new Question0105Exercise().solve(new Question0105Exercise.Params(new char[] { 'p', 'a', 'l', 'e', 's' }, new char[] { 'p', 'a', 'l', 'e' })));
        Assert.assertTrue(new Question0105Exercise().solve(new Question0105Exercise.Params(new char[] { 'p', 'a', 'l', 'e' }, new char[] { 'b', 'a', 'l', 'e' })));
        Assert.assertFalse(new Question0105Exercise().solve(new Question0105Exercise.Params(new char[] { 'p', 'a', 'l', 'e' }, new char[] { 'b', 'a', 'k', 'e' })));
    }

}
