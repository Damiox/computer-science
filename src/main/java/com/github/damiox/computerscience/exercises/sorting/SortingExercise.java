package com.github.damiox.computerscience.exercises.sorting;

import com.github.damiox.computerscience.Exercise;

public abstract class SortingExercise implements Exercise<Integer[]> {

    public abstract Results<Integer[]> solve(Params<Integer[]> params);

    protected void swap(final Integer[] A, final int i, final int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
