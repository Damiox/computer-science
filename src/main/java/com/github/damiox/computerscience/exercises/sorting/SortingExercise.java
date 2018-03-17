package com.github.damiox.computerscience.exercises.sorting;

import com.github.damiox.computerscience.Exercise;

public abstract class SortingExercise implements Exercise<Integer[], Integer[]> {

    public abstract Integer[] solve(Integer[] A);

    protected void swap(final Integer[] A, final int i, final int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public Integer[] solve(String S) {
        final char[] chars = S.toCharArray();
        final int n = chars.length;
        final Integer[] values = new Integer[n];
        for (int i = 0 ; i < chars.length ; i++) {
            values[i] = Character.codePointAt(chars, i);
        }

        return this.solve(values);
    }

}
