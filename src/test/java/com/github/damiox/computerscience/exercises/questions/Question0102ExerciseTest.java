package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

public class Question0102ExerciseTest {

    @Test
    public void testSolve() {
        // testing correct permutations
        Assert.assertTrue(new Question0102Exercise().solve(new Question0102Exercise.Params("A", "A")));
        Assert.assertTrue(new Question0102Exercise().solve(new Question0102Exercise.Params("ABC", "CAB")));
        Assert.assertTrue(new Question0102Exercise().solve(new Question0102Exercise.Params("DA", "AD")));
        Assert.assertTrue(new Question0102Exercise().solve(new Question0102Exercise.Params("DAMIAN", "NAAIDM")));
        Assert.assertTrue(new Question0102Exercise().solve(new Question0102Exercise.Params("AAAB", "ABAA")));
        Assert.assertTrue(new Question0102Exercise().solve(new Question0102Exercise.Params("", "")));
        // testing wrong permutations
        Assert.assertFalse(new Question0102Exercise().solve(new Question0102Exercise.Params("ABC", "DBA")));
        Assert.assertFalse(new Question0102Exercise().solve(new Question0102Exercise.Params("ABC", "CA")));
        Assert.assertFalse(new Question0102Exercise().solve(new Question0102Exercise.Params("ABCE", "ABCF")));
    }

}