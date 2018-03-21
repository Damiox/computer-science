package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;
import com.github.damiox.computerscience.exercises.sorting.HeapSortExercise;
import com.github.damiox.computerscience.exercises.sorting.SortingExercise;

/**
 * Check Permutation: Given two strings, write a method to decide
 * if one is a permutation of the other.
 *
 * Solution: We can sort both strings and make sure they are equal.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 *
 * Alternative solution: we can use a Hashtable and by doing that we'd
 * reduce the time complexity to O(n), but we'd need space complexity
 * of O(n). IMO it's better to have space complexity of O(1) and a
 * time complexity of O(n log n)
 *
 * @author dnardelli
 */
public class Question0102Exercise implements Exercise<Question0102Exercise.Params, Boolean> {

    public static class Params {
        public final String A;
        public final String B;

        Params(String A, String B) {
            this.A = A;
            this.B = B;
        }
    }

    private static final SortingExercise SORT = new HeapSortExercise();

    @Override
    public Boolean solve(Params params) {
        final String A = params.A;
        final String B = params.B;

        if (A == null || B == null) {
            throw new IllegalArgumentException("S cannot be empty");
        }

        if (A.length() != B.length()) {
            // if the length of both strings is not the same, then
            // they are obviously not a permutation between each other
            return false;
        }

        final Integer[] sortedA = SORT.solve(A);
        final Integer[] sortedB = SORT.solve(B);

        for (int i = 0 ; i < sortedA.length && i < sortedB.length ; i++) {
            if (!sortedA[i].equals(sortedB[i])) {
                return false;
            }
        }

        return true;
    }

}
