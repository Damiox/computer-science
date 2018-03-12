package com.github.damiox.computerscience.exercises.misc;

import com.github.damiox.computerscience.Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Question: Given two sorted arrays, find the number of elements in common.
 * The arrays are the same length and each has all distinct elements.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class FindCommonNumbersArrayExercise implements Exercise<FindCommonNumbersArrayExercise.Params, List<Integer>> {

    public static class Params {
        public final Integer[] A;
        public final Integer[] B;

        public Params(Integer[] A, Integer[] B) {
            this.A = A;
            this.B = B;
        }
    }

    @Override
    public List<Integer> solve(Params params) {
        final Integer[] A = params.A;
        final Integer[] B = params.B;

        if (A.length != B.length) {
            throw new IllegalArgumentException("arrays must have same length");
        }

        int i = 0;
        int j = 0;

        List<Integer> matches = new ArrayList<>();

        while (i < A.length && j < B.length) {
            if (A[i].equals(B[j])) {
                // found it
                matches.add(A[i]);
                i++;
                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else { // A[i] > B[j]
                j++;
            }
        }

        return matches;

        // Manual Debugging for A=[1,5,7,9,11] ; B=[3,7,11,21,23]
        // i = 0 ; j = 0
        // A[0] < B[0] -> i++
        // i = 1 ; j = 0
        // A[1] > B[0] -> j++
        // i = 1 ; j = 1
        // A[1] < B[1] -> i++
        // i = 2 ; j = 1
        // match!
        // i = 3 ; j = 2
        // A[3] < B[2] -> i++
        // i = 4 ; j = 2
        // match!
        // i = 5 ; j = 3 -> [x]

    }

}
