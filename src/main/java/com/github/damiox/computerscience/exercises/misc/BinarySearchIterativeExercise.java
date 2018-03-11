package com.github.damiox.computerscience.exercises.misc;

import com.github.damiox.computerscience.Exercise;

/**
 * Binary Search
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class BinarySearchIterativeExercise implements Exercise<BinarySearchIterativeExercise.ExerciseParams, Boolean> {

    public static class ExerciseParams {
        public final Integer[] A;
        public final int v;

        public ExerciseParams(Integer[] A, int v) {
            this.A = A;
            this.v = v;
        }
    }

    @Override
    public Boolean solve(final BinarySearchIterativeExercise.ExerciseParams params) {
        final Integer[] A = params.A;
        final int value = params.v;
        int n = A.length;
        int i = 0;

        while (i < A.length && n > 0) {
            final int mid = i + n / 2;

            if (A[mid] == value) {
                return true;
            } else if (A[mid] < value) {
                i = mid + 1;
            }

            n /= 2;
        }

        return false;

        // Manual Debugging for A = [1, 5, 7] ; n = 3 ; value = 1?
        // -> i = 0 ; n = 3
        // -> mid = 0 + 3 / 2 = 1
        // -> i = 0 ; n = 1
        // -> mid = 0 + 1 / 2 = 0
        // -> [x]

        // Manual Debugging for A = [1, 5, 7] ; n = 3 ; value = 7?
        // -> i = 0 ; n = 3
        // -> mid = 0 + 3 / 2 = 1
        // -> i = 2 ; n = 1
        // -> mid = 2 + 1 / 2 = 2
        // -> found it

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
