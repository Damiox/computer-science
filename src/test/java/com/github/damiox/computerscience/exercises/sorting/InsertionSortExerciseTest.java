package com.github.damiox.computerscience.exercises.sorting;

import com.github.damiox.computerscience.Exercise;
import org.junit.Assert;
import org.junit.Test;

public class InsertionSortExerciseTest {

    @Test
    public void testSorting() {
        Exercise.Results<Integer[]> results;

        results = new InsertionSortExercise().solve(() -> new Integer[] { 4, 3, 2, 10, 12, 1, 5, 6 });
        Assert.assertEquals(8, results.getResults().length);
        Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6, 10, 12}, results.getResults());

        results = new InsertionSortExercise().solve(() -> new Integer[] { 12, 11, 13, 5, 6 });
        Assert.assertEquals(5, results.getResults().length);
        Assert.assertArrayEquals(new Integer[] {5, 6, 11, 12, 13}, results.getResults());

        results = new InsertionSortExercise().solve(() -> new Integer[] { 1 });
        Assert.assertEquals(1, results.getResults().length);
        Assert.assertArrayEquals(new Integer[] { 1 }, results.getResults());

        results = new InsertionSortExercise().solve(() -> new Integer[] { 1, 2, 3 });
        Assert.assertEquals(3, results.getResults().length);
        Assert.assertArrayEquals(new Integer[] { 1, 2, 3 }, results.getResults());

        results = new InsertionSortExercise().solve(() -> new Integer[] { 7, 6, 5, 4, 3, 2, 1 });
        Assert.assertEquals(7, results.getResults().length);
        Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, results.getResults());

        results = new InsertionSortExercise().solve(() -> new Integer[] { 1, 2, 2, 3, 4, 2, 1, 2 });
        Assert.assertEquals(8, results.getResults().length);
        Assert.assertArrayEquals(new Integer[] { 1, 1, 2, 2, 2, 2, 3, 4 }, results.getResults());
    }

}
