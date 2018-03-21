package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;
import com.github.damiox.computerscience.exercises.sorting.HeapSortExercise;
import com.github.damiox.computerscience.exercises.sorting.SortingExercise;

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
 * Alternative solution: we can use a Hashtable and by doing that we'd
 * reduce the time complexity to O(n), but we'd need space complexity
 * of O(n). IMO it's better to have space complexity of O(1) and a
 * time complexity of O(n log n)
 *
 * @author dnardelli
 */
public class Question0101Exercise implements Exercise<String, Boolean> {

    private static final SortingExercise SORT = new HeapSortExercise();

    @Override
    public Boolean solve(String S) {
        if (S == null || S.length() == 0) {
            throw new IllegalArgumentException("S cannot be empty");
        }

        final Integer[] sortedS = SORT.solve(S);
        int prev = sortedS[0];
        for (int i = 1 ; i < sortedS.length ; i++) {
            int curr = sortedS[i];
            if (prev == curr) {
                return false;
            }
            prev = curr;
        }

        return true;
    }

}
