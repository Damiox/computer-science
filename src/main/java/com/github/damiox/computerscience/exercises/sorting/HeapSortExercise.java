package com.github.damiox.computerscience.exercises.sorting;

/**
 * This exercise is about sorting an array of number following the Insertion Sort algorithm.
 * For more information about this please see https://www.geeksforgeeks.org/heap-sort/
 *
 * Time Complexity: O(n * log n)
 * Space Complexity: O(log n)
 *
 * @author dnardelli
 */
public class HeapSortExercise extends SortingExercise {

    @Override
    public Integer[] solve(final Integer[] A) {
        int n = A.length;

        // First we need to create a valid max heap
        // that means our A[0] element will be the greatest in the array
        for (int i = n / 2 - 1 ; i >= 0 ; i--) {
            heapify(A, i, n);
        }

        // Secondly, we walk through the elements, and swap the first element by the 'n - i - 1' idx element.
        // After doing that we need to make sure to correct the heap again (heapify it).
        // By doing this we are going to heapify an array that is going to be smaller in each cycle
        for (int i = 0 ; i < n - 1 ; i++) {
            // it means now that A[0] has the bigger number, then swap!
            swap(A, 0, n - i - 1);
            heapify(A, 0,n - i - 1); // re-heapify again!
            // now the unsorted array is now smaller than before
        }

        // now I can say my array is sorted!
        return A;

        // Manual Debugging for A = [3, 4, 15, 6, 9, 1, 23] ; n = 7
        // 1) Heapify!
        // i = 2
        // -> heapify(A, 2, 7)
        //   -> l = 5 ; r = 6
        //   -> r >= 7 || A[5] >= A[6]? no -> e = r
        //   -> 23 > 15? yes
        //   -> swap(A, 2, 6) -> [3, 4, 23, 6, 9, 1, 15]
        //   -> heapify(A, 6, 7)
        //     -> l = 13 ; r = 14
        //     -> [x]
        // i = 1
        // -> heapify(A, 1, 7)
        //   -> l = 3 ; r = 4
        //   -> 4 >= 7 || A[3] >= A[4]? 6 >= 9? no, e = r
        //   -> 9 > 4? yes
        //   -> swap(A, 1, 4) -> [3, 9, 23, 6, 4, 1, 15]
        //   -> heapify(A, 4, 7)
        //     -> l = 9 ; r = 10
        //     -> [x]
        // i = 0
        // -> heapify(A, 0, 7)
        //   -> l = 1 ; r = 2
        //   -> 2 >= 7 || A[1] >= A[2]? 1 >= 23? no -> e = r
        //   -> 23 > 3? yes
        //   -> swap(A, 0, 2) -> [23, 9, 3, 6, 4, 1, 15]
        //   -> heapify(A, 2, 7)
        //     -> l = 5 ; r = 6
        //     -> 6 >= 7 || A[5] >= A[6]? no, -> e = r
        //     -> 15 > 3? yes
        //     -> swap(A, 2, 6) -> [23, 9, 15, 6, 4, 1, 3]
        //     -> heapify(A, 6, 7)
        //       -> l = 13 ; r = 14
        //       -> [x]
        // [x]

        // 2) sort
        // i = 0
        // -> swap(A, 0, n - i - 1) -> [3, 9, 15, 6, 4, 1, 23]
        // -> sorted array is [23] for now
        // -> unsorted array is [3, 9, 15, 6, 4, 1] for now
        // -> heapify(A, 0, 6)
        //   -> l = 1 ; r = 2
        //   -> e = r
        //   -> 15 > 3? yes
        //   -> swap(A, 0, 2) -> [15, 9, 3, 6, 4, 1]
        //   -> heapify(A, 2, 6)
        //     -> l = 5 ; r = 6
        //     -> e = l
        //     -> 1 > 3? no
        // i = 1
        // -> swap(A, 0, n - i - 1) -> [1, 9, 3, 6, 4, 15, 23]
        // -> sorted array is [15, 23] for now
        // -> unsorted array is [1, 9, 3, 6, 4] for now
        // -> heapify(A, 0, 5)
        //   -> l = 1 ; r = 2
        //   -> e = l
        //   -> 9 > 1? yes
        //   -> swap(A, 0, 1) -> [9, 1, 3, 6, 4]
        //   -> heapify(A, 1, 5)
        //     -> l = 3 ; r = 4
        //     -> e = l
        //     -> 6 > 1? yes
        //     -> swap(A, 1, 4) -> [9, 6, 3, 1, 4]
        //     -> heapify(A, 3, 5)
        //       -> l = 7 ; r = 8
        //       -> [x]
        // i = 2
        // -> swap(A, 0, n - i - 1) -> [4, 6, 3, 1, 9, 15, 23]
        // -> sorted array is [9, 15, 23] for now
        // -> unsorted array is [4, 6, 3, 1] for now
        // -> heapify(A, 0, 4)
        //   -> l = 1 ; r = 2
        //   -> e = l
        //   -> 6 > 4? yes
        //   -> swap(A, 0, 1) -> [6, 4, 3, 1]
        //   -> heapify(A, 1, 4)
        //     -> l = 3 ; r = 4
        //     -> e = l
        //     -> 3 > 4? no [x]
        // i = 3
        // -> swap(A, 0, n - i - 1) -> [1, 4, 3, 6, 9, 15, 23]
        // -> sorted array is [6, 9, 15, 23] for now
        // -> unsorted array is [1, 4, 3] for now
        // -> heapify(A, 0, 3)
        //   -> l = 1 ; r = 2
        //   -> e = l
        //   -> 4 > 1? yes
        //   -> swap(A, 0, 1) -> [4, 1, 3]
        //   -> heapify(A, 1, 3)
        //     -> l = 3 ; r = 4
        //     -> [x]
        // i = 4
        // -> swap(A, 0, n - i - 1) -> [3, 1, 4, 6, 9, 15, 23]
        // -> sorted array is [4, 6, 9, 15, 23] for now
        // -> unsorted array is [3, 1] for now
        // -> heapify(A, 0, 2)
        //   -> l = 1 ; r = 2
        //   -> e = l
        //   -> 1 > 3? no
        //   -> [x]
        // i = 5
        // -> swap(A, 0, n - i - 1) -> [1, 3, 4, 6, 9, 15, 23]
        // -> sorted array is [3, 4, 6, 9, 15, 23] for now
        // -> unsorted array is [1] for now
        // -> heapify(A, 0, 1)
        //   -> l = 1 ; r = 2
        //   -> [x]
        // finally, sorted array is: [1, 3, 4, 6, 9, 15, 23]
    }

    private void heapify(final Integer[] A, final int i, final int n) {
        final int l = left(i);
        final int r = right(i);

        if (l >= n && r >= n) {
            // out of bounds
            return;
        }

        final int e = compare(A, l, r, n);

        if (A[e] > A[i]) {
            swap(A, i, e);
            // re-heapify
            heapify(A, e, n);
        }
    }

    private int compare(Integer[] A, int l, int r, int n) {
        // if 'r' is out of bounds, or l is greater than r, then evaluating l son
        return r >= n || A[l] >= A[r] ? l : r;
    }

    private int parent(int idx) {
        return (idx - 1) / 2;
    }

    private int left(int idx) {
        return 2 * idx + 1;
    }

    private int right(int idx) {
        return 2 * idx + 2;
    }

}
