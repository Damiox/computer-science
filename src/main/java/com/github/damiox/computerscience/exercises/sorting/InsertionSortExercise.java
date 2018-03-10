package com.github.damiox.computerscience.exercises.sorting;

import com.github.damiox.computerscience.Exercise;

/**
 * This exercise is about sorting an array of number following the Insertion Sort algorithm.
 * For more information about this please see https://www.geeksforgeeks.org/insertion-sort/
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class InsertionSortExercise implements Exercise<Integer[]> {

    @Override
    public Results<Integer[]> solve(Params<Integer[]> params) {
        final Integer[] array = params.getParams();

        for (int i = 0 ; i < array.length - 1 ; i++) {
            for (int j = i + 1 ; j < array.length ; j++) {
                if (array[j] < array[i]) {
                    swap(array, i, j);
                }
            }
        }

        // Manual Debugging for [12, 11, 13, 5, 6]
        //i = 0 ; j = 1 -> array[1] < array[0] ? yes -> swap -> [11, 12, 13, 5, 6]
        //i = 0 ; j = 2 -> array[2] < array[0] ? no
        //i = 0 ; j = 3 -> array[3] < array[0] ? yes -> swap -> [5, 12, 13, 11, 6]
        //i = 0 ; j = 4 -> array[4] < array[0] ? no
        //i = 1 ; j = 2 -> array[1] < array[2] ? no
        //i = 1 ; j = 3 -> array[1] < array[3] ? yes -> swap -> [5, 11, 13, 12, 6]
        //i = 1 ; j = 2 -> array[1] < array[4] ? yes -> swap -> [5, 6, 13, 12, 11]
        //i = 2 ; j = 3 -> array[2] < array[3] ? yes -> swap -> [5, 6, 12, 13, 11]
        //i = 2 ; j = 3 -> array[2] < array[4] ? yes -> swap -> [5, 6, 11, 13, 12]
        //i = 3 ; j = 4 -> array[2] < array[4] ? yes -> swap -> [5, 6, 11, 12, 13]

        return () -> array;
    }

    private void swap(final Integer[] A, final int i, final int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
