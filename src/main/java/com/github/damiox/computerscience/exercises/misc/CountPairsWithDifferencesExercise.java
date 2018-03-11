package com.github.damiox.computerscience.exercises.misc;

import com.github.damiox.computerscience.Exercise;
import com.github.damiox.computerscience.exercises.sorting.HeapSortExercise;

/**
 * Example: Given an array of distinct integer values, count the number of
 * pairs of integers that have difference k. For example, given the array
 * {1, 7, 5, 9, 2, 12, 3} and the difference k = 2, there are four pairs
 * with difference 2: (1, 3), (3, 5), (5, 7), (7, 9).
 *
 * Time Complexity: O(n * log n)
 * Space Complexity: O(1) (without considering the space for sorting)
 *
 * @author dnardelli
 */
public class CountPairsWithDifferencesExercise implements Exercise<CountPairsWithDifferencesExercise.ExerciseParams, Integer> {

    public static class ExerciseParams {
        public final Integer[] A;
        public final int k;

        public ExerciseParams(Integer[] A, int k) {
            this.A = A;
            this.k = k;
        }
    }

    @Override
    public Integer solve(ExerciseParams params) {
        // Heap Sort: O(n * log n)
        // so 'A' will be sorted now.
        final Integer[] A = new HeapSortExercise().solve(params.A);
        final int n = A.length;
        final int k = params.k;

        // As the 'A' array is now sorted, then we make some valid assumptions while walking through 'A'
        // First, if A[j] - A[i] is lower than 'k', then we can increment 'j' otherwise we increment 'i'
        int i = 0;
        int j = 1;
        int count = 0;

        while (i < n && j < n) {
            int diff = A[j] - A[i];

            if (diff == k) {
                count++; // new pair!
                // moving to next (remember that integers are distincts between each other
                // so we are safe to move both pointers
                i++;
                j++;
            } else if (diff < k) {
                // the difference is too small...
                // if we increment i, then we will get smaller differences, that's why we try with 'j'
                j++;
            } else if (diff > k) {
                // the difference is bigger than expected
                // if we increment j, then we will get bigger differences, that's why we try with 'i'
                i++;
            }
        }

        return count;
    }



}
