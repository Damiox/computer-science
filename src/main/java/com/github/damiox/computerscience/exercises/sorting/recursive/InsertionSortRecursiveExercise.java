package com.github.damiox.computerscience.exercises.sorting.recursive;

import com.github.damiox.computerscience.exercises.sorting.SortingExercise;

import java.util.Arrays;

/**
 * This exercise is about sorting an array of number following the Insertion Sort algorithm.
 * For more information about this please see https://www.geeksforgeeks.org/insertion-sort/
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 *
 * @author dnardelli
 */
public class InsertionSortRecursiveExercise extends SortingExercise {

    @Override
    public Integer[] solve(final Integer[] A) {
        return this.solve(A, 0);

        // Manual Debugging for [12, 11, 13, 5, 6]
        // solve(A, 0)
        // k >= 4? no
        // A[1] < A[0]? yes -> swap -> [11, 12, 13, 5, 6]
        // k > 0? yes
        // solve(A, 1) [x]
        // -> k >= 4? no
        // -> A[2] < A[1]? no
        // -> solve(A, 2) [x]
        //   -> k >= 4? no
        //   -> A[3] < A[2]? yes -> swap -> [11, 12, 5, 13, 6]
        //   -> k > 0? yes
        //   -> solve(A, 1) [x]
        //     -> k >= 4? no
        //     -> A[2] < A[1]? yes -> swap -> [11, 5, 12, 13, 6]
        //     -> k > 0? yes
        //     -> solve(A, 0) [x]
        //       -> k >= 4? no
        //       -> A[1] < A[0]? yes -> swap -> [5, 11, 12, 13, 6]
        //       -> k > 0? no
        //       -> solve(A, 1) [x]
        //         -> k >= 4? no
        //         -> A[2] < A[1]? no
        //         -> solve(A, 2) [x]
        //           -> k >= 4? no
        //           -> A[3] < A[2]? no
        //           -> solve(A, 3) [x]
        //             -> k >= 4? no
        //             -> A[4] < A[3]? yes -> swap -> [5, 11, 12, 6, 13]
        //             -> k > 0? yes
        //             -> solve(A, 2) [x]
        //               -> k >= 4? no
        //               -> A[3] < A[2]? yes -> swap -> [5, 11, 6, 12, 13]
        //               -> k > 0? yes
        //               -> solve(A, 1) [x]
        //                 -> k >= 4? no
        //                 -> A[2] < A[1]? yes -> swap -> [5, 6, 11, 12, 13]
        //                 -> k > 0? yes
        //                 -> solve(A, 0) [x]
        //                   -> k >= 4? no
        //                   -> A[1] < A[0]? no
        //                   -> solve(A, 1) [x]
        //                     -> k >= 4? no
        //                     -> A[2] < A[1]? no
        //                     -> solve(A, 2) [x]
        //                       -> k >= 4? no
        //                       -> A[3] < A[2]? no
        //                       -> solve(A, 3) [x]
        //                         -> k >= 4? no
        //                         -> A[4] < A[3]? no
        //                         -> solve(A, 4) [x]
        //                           -> k >= 4? yes (k = 4) -> return A [x]
        // finally, sorted array is: [5, 6, 11, 12, 13]

    }

    private Integer[] solve(Integer[] A, int k) {
        if (k >= A.length - 1) {
            return A;
        }

        if (A[k + 1] < A[k]) {
            swap(A, k, k + 1);
            if (k > 0) {
                return solve(A, k - 1);
            }
        }

        return solve(A, k + 1);
    }

}
