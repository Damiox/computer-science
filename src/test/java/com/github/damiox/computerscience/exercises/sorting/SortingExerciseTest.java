package com.github.damiox.computerscience.exercises.sorting;

import com.github.damiox.computerscience.Exercise;
import com.github.damiox.computerscience.exercises.sorting.iterative.InsertionSortIterativeExercise;
import com.github.damiox.computerscience.exercises.sorting.iterative.SelectionSortIterativeExercise;
import com.github.damiox.computerscience.exercises.sorting.recursive.InsertionSortRecursiveExercise;
import com.github.damiox.computerscience.exercises.sorting.recursive.SelectionSortRecursiveExercise;
import org.junit.Assert;
import org.junit.Test;

public class SortingExerciseTest {

    @Test
    public void testSelectionSort() {
        this.testSortingExercise(new SelectionSortIterativeExercise());
        this.testSortingExercise(new SelectionSortRecursiveExercise());
    }

    @Test
    public void testInsertionSort() {
        this.testSortingExercise(new InsertionSortIterativeExercise());
        this.testSortingExercise(new InsertionSortRecursiveExercise());
    }

    @Test
    public void testHeapSort() {
        this.testSortingExercise(new HeapSortExercise());
    }

    private void testSortingExercise(SortingExercise sortingExercise) {
        Integer[] results;

        results = sortingExercise.solve(new Integer[] { 4, 3, 2, 10, 12, 1, 5, 6 });
        Assert.assertEquals(8, results.length);
        Assert.assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 6, 10, 12}, results);

        results = sortingExercise.solve(new Integer[] { 12, 11, 13, 5, 6 });
        Assert.assertEquals(5, results.length);
        Assert.assertArrayEquals(new Integer[] {5, 6, 11, 12, 13}, results);

        results = sortingExercise.solve(new Integer[] { 1 });
        Assert.assertEquals(1, results.length);
        Assert.assertArrayEquals(new Integer[] { 1 }, results);

        results = sortingExercise.solve(new Integer[] { 1, 2, 3 });
        Assert.assertEquals(3, results.length);
        Assert.assertArrayEquals(new Integer[] { 1, 2, 3 }, results);

        results = sortingExercise.solve(new Integer[] { 7, 6, 5, 4, 3, 2, 1 });
        Assert.assertEquals(7, results.length);
        Assert.assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }, results);

        results = sortingExercise.solve(new Integer[] { 1, 2, 2, 3, 4, 2, 1, 2 });
        Assert.assertEquals(8, results.length);
        Assert.assertArrayEquals(new Integer[] { 1, 1, 2, 2, 2, 2, 3, 4 }, results);
    }
}
