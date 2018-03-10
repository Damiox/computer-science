package com.github.damiox.computerscience.exercises.sorting.recursive;

import com.github.damiox.computerscience.exercises.sorting.SortingExercise;

/**
 * This exercise is about sorting an array of number following the Selection Sort algorithm.
 * For more information about this please see https://www.geeksforgeeks.org/selection-sort/
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 *
 * @author dnardelli
 */
public class SelectionSortRecursiveExercise extends SortingExercise {

    @Override
    public Results<Integer[]> solve(Params<Integer[]> params) {
        return () -> this.solve(params.getParams(), 0);

        // Manual Debugging for [12, 11, 13, 5, 6]
        // solve(A, 0)
        // i >= 4? no
        // findMin(A)
        //     -> findMin(A, 1, 0) [x]
        //       -> i >= 4? no
        //       -> A[1] < A[0]? yes -> min = 1
        //       -> findMin(A, 2, 1) [x]
        //         -> i >= 4? no
        //         -> A[2] < A[1]? no
        //         -> findMin(A, 3, 1) [x]
        //           -> i >= 4? no
        //           -> A[3] < A[1]? yes -> min = 3
        //           -> findMin(A, 4, 3) [x]
        //             -> i >= 4? no
        //             -> A[4] < A[3]? no
        //             -> findMin(A, 5, 3) [x]
        //               -> i >= 4? yes -> return min = 3 ; A[min] = 5
        // swap(A, 0, 3) -> [5, 11, 13, 12, 6]
        // solve(A, 1) [x]
        // -> i >= 4? no
        //   -> findMin(A, 2, 1) [x]
        //     -> i >= 4? no
        //     -> A[2] < A[1]? no
        //     -> findMin(A, 3, 1) [x]
        //       -> i >= 4? no
        //       -> A[3] < A[1]? no
        //       -> findMin(A, 4, 1) [x]
        //         -> i >= 4? no
        //         -> A[4] < A[1]? yes -> min = 4
        //         -> findMin(A, 5, 4) [x]
        //         -> i >= 4? yes -> return min = 4 ; A[min] = 6
        // -> swap(A, 1, 4) -> [5, 6, 13, 12, 11]
        // -> solve(A, 2) [x]
        //   -> i >= 4? no
        //       -> A[2] < A[2]? no
        //       -> findMin(A, 3, 2) [x]
        //         -> i >= 4? no
        //         -> A[3] < A[2]? yes -> min = 3
        //         -> findMin(A, 4, 3) [x]
        //           -> i >= 4? no
        //           -> A[4] < A[3]? yes -> min = 4
        //           -> findMin(A, 5, 4) [x]
        //           -> i >= 4? yes -> min = 4 ; A[min] = 11
        //   -> swap(A, 2, 4) -> [5, 6, 11, 12, 13]
        //   -> solve(A, 3) [x]
        //     -> i >= 4? no
        //     -> findMin(A, 4, 3)
        //       -> i >= 4? no
        //       -> A[4] < A[3]? no
        //       -> findMIn(A, 5, 4)
        //         -> i >= 4? yes, return min = 3 w/o changes
        //     -> no swap because i == min
        //     -> solve(A, 4) [x]
        //       -> i >= 4? yes [x]
        // finally, sorted array is: [5, 6, 11, 12, 13]

    }

    private Integer[] solve(Integer[] A, int i) {
        if (i >= A.length - 1) {
            return A;
        }

        int min = findMin(A, i + 1, i);

        if (i != min) {
            swap(A, i, min);
        }

        return solve(A, i + 1);
    }

    private int findMin(Integer[] A, int i, int min) {
        if (i > A.length - 1) {
            return min;
        }

        if (A[i] < A[min]) {
            min = i;
        }

        return findMin(A, i + 1, min);
    }

}
