package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;
import com.github.damiox.computerscience.exercises.sorting.HeapSortExercise;
import com.github.damiox.computerscience.exercises.sorting.SortingExercise;

/**
 * Palindrome Permutation: Given a string, write a function to check
 * if it is a permutation of a palin- drome. A palindrome is a word
 * or phrase that is the same forwards and backwards. A permutation
 * is a rearrangement of letters.The palindrome does not need to be
 * limited to just dictionary words.
 *
 * Solution: We can sort the String and then count the number of chars.
 * We know there are some restrictions about palindromes.
 * 1) if chars are found an even number of times, that's fine.
 * 2) if chars are found an odd number of times, that can only happen once.
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class Question0104Exercise implements Exercise<String, Boolean> {

    private static final SortingExercise SORT = new HeapSortExercise();
    private static final int SPACE = ' ';

    @Override
    public Boolean solve(String S) {
        if (S == null) {
            throw new IllegalArgumentException("S cannot be null");
        }

        if (S.length() == 0) {
            return true;
        }

        Integer[] sortedS = SORT.solve(S.toLowerCase());

        int odds = 0;
        int found = 0;
        int prev = -1;

        for (int i = 0 ; i < sortedS.length ; i++) {
            int curr = sortedS[i];

            // ignore whitespaces...
            if (curr == SPACE) {
                continue;
            }

            if (prev == -1 || curr == prev) {
                found++;
            } else {
                if (found % 2 > 0) { // odd
                    odds++;
                    if (odds > 1) {
                        return false;
                    }
                }
                found = 1;
            }

            prev = curr;
        }

        // just for the last char...
        if (found % 2 > 0 && odds == 1) {
            return false;
        }

        return true;
    }

}
