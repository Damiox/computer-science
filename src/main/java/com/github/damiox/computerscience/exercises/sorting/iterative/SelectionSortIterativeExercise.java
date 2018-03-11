package com.github.damiox.computerscience.exercises.sorting.iterative;

import com.github.damiox.computerscience.exercises.sorting.SortingExercise;

/**
 * This exercise is about sorting an array of number following the Selection Sort algorithm.
 * For more information about this please see https://www.geeksforgeeks.org/selection-sort/
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class SelectionSortIterativeExercise extends SortingExercise {

    @Override
    public Integer[] solve(final Integer[] A) {
        for (int i = 0 ; i < A.length - 1 ; i++) {

            // Honestly, I would say this algorithm is the easiest one to implement
            // Clearly the time complexity is horrendously inefficient.
            int minJ = i;

            for (int j = i + 1 ; j < A.length ; j++) {
                if (A[j] < A[minJ]) {
                    minJ = j;
                }
            }

            if (minJ != i) {
                swap(A, i, minJ);
            }

        }

        return A;

        // Manual Debugging for [12, 11, 13, 5, 6]
        // i = 0 ; minJ = 0 ; j = 1 -> array[1] < array[0] ? yes -> minJ = 1
        // i = 0 ; minJ = 1 ; j = 2 -> array[2] < array[1] ? no
        // i = 0 ; minJ = 1 ; j = 3 -> array[3] < array[1] ? yes -> minJ = 3
        // i = 0 ; minJ = 3 ; j = 4 -> array[4] < array[3] ? no
        // then: swap(array, 0, 3) -> [5, 11, 13, 12, 6]
        // i = 1 ; minJ = 1 ; j = 2 -> array[2] < array[1] ? no
        // i = 1 ; minJ = 1 ; j = 3 -> array[3] < array[1] ? no
        // i = 1 ; minJ = 1 ; j = 4 -> array[4] < array[1] ? yes -> minJ = 4
        // then: swap(array, 1, 4) -> [5, 6, 13, 12, 11]
        // i = 2 ; minJ = 2 ; j = 3 -> array[3] < array[2] ? yes -> minJ = 3
        // i = 2 ; minJ = 3 ; j = 4 -> array[4] < array[3] ? yes -> minJ = 4
        // then: swap(array, 2, 4) -> [5, 6, 11, 12, 13]
        // i = 3 ; minJ = 3 ; j = 4 -> array[4] < array[3] ? no
        // finally, sorted array is: [5, 6, 11, 12, 13]

    }

}
