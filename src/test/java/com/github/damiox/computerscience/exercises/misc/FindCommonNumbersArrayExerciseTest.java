package com.github.damiox.computerscience.exercises.misc;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FindCommonNumbersArrayExerciseTest {

    @Test
    public void testSolve() {
        List<Integer> matches;

        matches = new FindCommonNumbersArrayExercise().solve(new FindCommonNumbersArrayExercise.Params(new Integer[] { 1, 5, 7, 9, 11}, new Integer[] { 3, 7, 11, 21, 23}));
        Assert.assertEquals(2, matches.size());
        Assert.assertTrue(matches.contains(7));
        Assert.assertTrue(matches.contains(11));

        matches = new FindCommonNumbersArrayExercise().solve(new FindCommonNumbersArrayExercise.Params(new Integer[] { 1, 11}, new Integer[] { 1, 11}));
        Assert.assertEquals(2, matches.size());
        Assert.assertTrue(matches.contains(1));
        Assert.assertTrue(matches.contains(11));

        matches = new FindCommonNumbersArrayExercise().solve(new FindCommonNumbersArrayExercise.Params(new Integer[] { 111}, new Integer[] { 111}));
        Assert.assertEquals(1, matches.size());
        Assert.assertTrue(matches.contains(111));

        matches = new FindCommonNumbersArrayExercise().solve(new FindCommonNumbersArrayExercise.Params(new Integer[] { 1, 11}, new Integer[] { 0, 23}));
        Assert.assertTrue(matches.isEmpty());
    }

}
