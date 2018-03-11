package com.github.damiox.computerscience.exercises.misc;

import com.github.damiox.computerscience.Exercise;

public class BinarySearchExercise implements Exercise<BinarySearchExercise.ExerciseParams, Boolean> {

    public static class ExerciseParams {
        public final Integer[] A;
        public final int v;

        public ExerciseParams(Integer[] A, int v) {
            this.A = A;
            this.v = v;
        }
    }

    @Override
    public Boolean solve(final BinarySearchExercise.ExerciseParams params) {
        return search(params.A, params.v, 0, params.A.length);
    }

    private boolean search(final Integer[] A, final int value, int i, int n) {
        int mid = i + n / 2;

        // Value out of bounds - we won't find it
        if (i < 0 || n == 0) {
            return false;
        }

        if (A[mid] < value) {
            return search(A, value, mid, n / 2);
        } else if (A[mid] > value) {
            return search(A, value, i, n / 2);
        }

        return true;

        // Manual Debugging for A = [1, 5, 7] ; n = 3 ; value = 0?
        // -> i = 0 ; n = 3
        // -> mid = 0 + 3 / 2 = 1
        // -> 5 > 0
        // -> search(A, 0, 0, 1)
        //   -> i = 0 ; n = 1
        //   -> mid = 0 + 1 / 2 = 0
        //   -> 1 > 0
        //   -> search(A, 0, 0, 0)
        //   -> [x]

        // Manual Debugging for A = [1, 5, 7] ; n = 3 ; value = 8?
        // -> i = 0 ; n = 3
        // -> mid = 0 + 3 / 2 = 1
        // -> 5 < 8
        // -> search(A, 0, 1, 1)
        //   -> i = 1 ; n = 1
        //   -> mid = 1 + 1 / 2 = 1
        //   -> 1 < 8
        //   -> search(A, 0, 1, 0)
        //   -> [x]

        // Manual Debugging for A = [1, 5, 7, 9, 22, 34, 50, 51, 52, 90] ; n = 10 ; value = 52?
        // -> i = 0 ; n = 10
        // -> mid = 0 + 10 / 2 = 5
        // -> 34 < 52
        // -> search(A, 52, 5, 5)
        //   -> i = 5 ; n = 5
        //   -> mid = 5 + 5 / 2 = 7
        //   -> 51 < 52
        //   -> search(A, 52, 7, 2)
        //   -> i = 7 ; n = 2
        //   -> mid = 7 + 2 / 2 = 8
        //   -> found it
    }
}
