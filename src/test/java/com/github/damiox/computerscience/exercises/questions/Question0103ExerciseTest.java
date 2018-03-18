package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

public class Question0103ExerciseTest {

    @Test
    public void testSolve() {
        Assert.assertEquals("Mr%20John%20Smith", new Question0103Exercise().solve(new Question0103Exercise.Params(new char[] { 'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' ' }, 13)));
        Assert.assertEquals("Hi%20there%20!", new Question0103Exercise().solve(new Question0103Exercise.Params(new char[] { 'H', 'i', ' ', 't', 'h', 'e', 'r', 'e', ' ', '!', ' ', ' ', ' ', ' ' }, 10)));
        Assert.assertEquals("d%20m%20%20n", new Question0103Exercise().solve(new Question0103Exercise.Params(new char[] { 'd', ' ', 'm', ' ', ' ', 'n', ' ', ' ', ' ', ' ', ' ', ' ' }, 6)));
    }

}
