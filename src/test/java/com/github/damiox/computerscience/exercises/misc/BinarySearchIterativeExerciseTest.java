package com.github.damiox.computerscience.exercises.misc;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchIterativeExerciseTest {

    @Test
    public void testSolve() {
        Assert.assertTrue(new BinarySearchIterativeExercise().solve(new BinarySearchIterativeExercise.ExerciseParams(new Integer[] {1, 5, 7}, 1)));
        Assert.assertTrue(new BinarySearchIterativeExercise().solve(new BinarySearchIterativeExercise.ExerciseParams(new Integer[] {1, 5, 7}, 5)));
        Assert.assertTrue(new BinarySearchIterativeExercise().solve(new BinarySearchIterativeExercise.ExerciseParams(new Integer[] {1, 5, 7}, 7)));
        Assert.assertTrue(new BinarySearchIterativeExercise().solve(new BinarySearchIterativeExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 27)));
        Assert.assertTrue(new BinarySearchIterativeExercise().solve(new BinarySearchIterativeExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 1)));
        Assert.assertTrue(new BinarySearchIterativeExercise().solve(new BinarySearchIterativeExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 5)));
        Assert.assertTrue(new BinarySearchIterativeExercise().solve(new BinarySearchIterativeExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 99)));
        Assert.assertTrue(new BinarySearchIterativeExercise().solve(new BinarySearchIterativeExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 25)));
        Assert.assertFalse(new BinarySearchIterativeExercise().solve(new BinarySearchIterativeExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 2)));
        Assert.assertFalse(new BinarySearchIterativeExercise().solve(new BinarySearchIterativeExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 0)));
        Assert.assertFalse(new BinarySearchIterativeExercise().solve(new BinarySearchIterativeExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 100)));
        Assert.assertFalse(new BinarySearchIterativeExercise().solve(new BinarySearchIterativeExercise.ExerciseParams(new Integer[] {1, 5, 7, 9, 22, 25, 27, 99}, 23)));
        Assert.assertFalse(new BinarySearchIterativeExercise().solve(new BinarySearchIterativeExercise.ExerciseParams(new Integer[] {1, 5, 7}, 0)));
        Assert.assertFalse(new BinarySearchIterativeExercise().solve(new BinarySearchIterativeExercise.ExerciseParams(new Integer[] {1, 5, 7}, 8)));
    }

}
