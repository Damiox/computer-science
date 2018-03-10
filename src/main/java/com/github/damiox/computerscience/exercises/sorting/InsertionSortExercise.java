package com.github.damiox.computerscience.exercises.sorting;

/**
 * This exercise is about sorting an array of number following the Insertion Sort algorithm.
 * For more information about this please see https://www.geeksforgeeks.org/insertion-sort/
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class InsertionSortExercise extends SortingExercise {

    @Override
    public Results<Integer[]> solve(Params<Integer[]> params) {
        final Integer[] array = params.getParams();

        for (int i = 0 ; i < array.length ; i++) {

            int k = i;
            int j = i - 1;

            // Solution published in geeks4geeks is using a 'key' variable instead of our 'k' variable
            // so the implementation is different, but the essence of what we are looking for is the same.
            // Maybe that implementation makes more sense because we are just trying to correctly locate the A[i] value
            // that the algorithm is evaluating.
            // On the other hand, our algorithm is swapping k with and i, and assigning k with the new j
            // that was just swapped and repeating this process.
            // But it turns out that A[k] will always be the initial A[i] that we are evaluating.
            // So both implementations are doing the same.
            while (j >= 0 && array[k] < array[j]) {
                swap(array, k, j);
                k = j;
                j = k - 1;
            }

        }

        return () -> array;

        // Manual Debugging for [12, 11, 13, 5, 6]
        // i = 0
        // k = 0
        // j = -1
        // j >= 0? no, next and for now sorted array is [12]
        // --
        // i = 1
        // k = 1
        // j = 0
        // j >= 0? yes
        // A[1] < A[0]? yes
        // swap(A, 1, 0) -> [11, 12, 13, 5, 6]
        // k = 0
        // j = -1
        // j >= 0? no, next and for now sorted array is [11, 12]
        // --
        // i = 2
        // k = 2
        // j = 1
        // j >= 0? yes
        // A[2] < A[1]? no, next and for now sorted array is [11, 12, 13]
        // --
        // i = 3
        // k = 3
        // j = 2
        // j >= 0? yes
        // A[3] < A[2]? yes
        // swap(A, 3, 2) -> [11, 12, 5, 13]
        // k = 2
        // j = 1
        // j >= 0? yes
        // A[2] < A[1]? yes
        // swap(A, 2, 1) -> [11, 5, 12, 13]
        // k = 1
        // j = 0
        // j >= 0? yes
        // A[1] < A[0]? yes
        // swap(A, 1, 0) -> [5, 11, 12, 13]
        // k = 0
        // j = -1
        // j >= 0? no, next and for now sorted array is [5, 11, 12, 13]
        // --
        // i = 4
        // k = 4
        // j = 3
        // j >= 0? yes
        // A[4] < A[3]? yes
        // swap(A, 4, 3) -> [5, 11, 12, 6, 13]
        // k = 3
        // j = 2
        // j >= 0? yes
        // A[3] < A[2]? yes
        // swap(A, 3, 2) -> [5, 11, 6, 12, 13]
        // k = 2
        // j = 1
        // j >= 0? yes
        // A[2] < A[1]? yes
        // swap(A, 2, 1) -> [5, 6, 11, 12, 13]
        // k = 1
        // j = 0
        // j >= 0? yes
        // A[1] < A[0]? no, next and for now sorted array is [5, 6, 11, 12, 13]
        // finally, sorted array is: [5, 6, 11, 12, 13]

    }

}
