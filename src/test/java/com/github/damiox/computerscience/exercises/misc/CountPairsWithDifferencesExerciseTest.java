package com.github.damiox.computerscience.exercises.misc;

import org.junit.Assert;
import org.junit.Test;

public class CountPairsWithDifferencesExerciseTest {

    @Test
    public void testSolve() {
        Assert.assertEquals(2, (long)new CountPairsWithDifferencesExercise().solve(new CountPairsWithDifferencesExercise.ExerciseParams(new Integer[] {7, 5, 22, 9, 1}, 2)));
        Assert.assertEquals(2, (long)new CountPairsWithDifferencesExercise().solve(new CountPairsWithDifferencesExercise.ExerciseParams(new Integer[] {7, 5, 22, 9, 1}, 4)));
        Assert.assertEquals(0, (long)new CountPairsWithDifferencesExercise().solve(new CountPairsWithDifferencesExercise.ExerciseParams(new Integer[] {1}, 4)));
        Assert.assertEquals(0, (long)new CountPairsWithDifferencesExercise().solve(new CountPairsWithDifferencesExercise.ExerciseParams(new Integer[] {1}, 1)));
        Assert.assertEquals(4, (long)new CountPairsWithDifferencesExercise().solve(new CountPairsWithDifferencesExercise.ExerciseParams(new Integer[] {55, 12, 13, 14, 15, 16}, 1)));
    }

}
