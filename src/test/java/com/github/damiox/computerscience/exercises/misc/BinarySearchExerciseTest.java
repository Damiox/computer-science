package com.github.damiox.computerscience.exercises.misc;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchExerciseTest {

    @Test
    public void testSolve() {
        Assert.assertTrue(new BinarySearchExercise().solve(new BinarySearchExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 27)));
        Assert.assertTrue(new BinarySearchExercise().solve(new BinarySearchExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 1)));
        Assert.assertTrue(new BinarySearchExercise().solve(new BinarySearchExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 5)));
        Assert.assertTrue(new BinarySearchExercise().solve(new BinarySearchExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 99)));
        Assert.assertTrue(new BinarySearchExercise().solve(new BinarySearchExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 25)));
        Assert.assertFalse(new BinarySearchExercise().solve(new BinarySearchExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 2)));
        Assert.assertFalse(new BinarySearchExercise().solve(new BinarySearchExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 0)));
        Assert.assertFalse(new BinarySearchExercise().solve(new BinarySearchExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 100)));
        Assert.assertFalse(new BinarySearchExercise().solve(new BinarySearchExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 23)));
    }

}
