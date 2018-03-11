package com.github.damiox.computerscience.exercises.sorting;

import com.github.damiox.computerscience.Exercise;

public abstract class SortingExercise implements Exercise<Integer[], Integer[]> {

    public abstract Integer[] solve(Integer[] A);

    protected void swap(final Integer[] A, final int i, final int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
