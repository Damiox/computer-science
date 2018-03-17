package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;
import com.github.damiox.computerscience.exercises.sorting.HeapSortExercise;

/**
 * Is Unique: Implement an algorithm to determine if a string
 * has all unique characters. What if you cannot use additional
 * data structures?
 *
 * Solution: We can sort the string and then make sure the previous
 * character is not equal to the current character.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class Question0101Exercise implements Exercise<String, Boolean> {

    private static final Sort SORT = new Sort();

    @Override
    public Boolean solve(String S) {
        if (S == null || S.length() == 0) {
            throw new IllegalArgumentException("S cannot be empty");
        }

        final Integer[] values = SORT.sort(S);
        int prev = values[0];
        for (int i = 1 ; i < values.length ; i ++) {
            int curr = values[i];
            if (prev == curr) {
                return false;
            }
            prev = curr;
        }

        return true;
    }

    private static class Sort {
        Integer[] sort(String S) {
            // Our HeapSort takes an array of Integer as parameter
            // so we will convert our S into an array of integers
            final char[] chars = S.toCharArray();
            final int n = chars.length;
            final Integer[] values = new Integer[n];
            for (int i = 0 ; i < chars.length ; i++) {
                values[i] = Character.codePointAt(chars, i);
            }

            return new HeapSortExercise().solve(values);
        }
    }

}
