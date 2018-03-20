package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;

/**
 * Rotate Matrix: Given an image represented by an NxN matrix,
 * where each pixel in the image is 4 bytes, write a method
 * to rotate the image by 90 degrees. (an you do this in place?
 *
 * Solution: walk through matrix and rotate 4 times as follows:
 * 1) tmp = M[j][n-1-i]
 * 2) M[j][n-1-i] = M[i][j]
 * 3) use 'tmp' variable for next iteration, do this 3 more times.
 *
 * We are rotating to right.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class Question0107Exercise implements Exercise<Integer[][], Integer[][]> {

    @Override
    public Integer[][] solve(Integer[][] M) {
        final int n = M.length;

        for (int i = 0 ; i < n ; i++) {
            for (int j = i ; j < n - 1 - i ; j++) {
                final int[] ij1 = { i, j };
                final int[] ij2 = getRotateCoords(ij1, n);
                final int[] ij3 = getRotateCoords(ij2, n);
                final int[] ij4 = getRotateCoords(ij3, n);

                int tmp;
                tmp = rotateCoords(M, ij2, M[i][j]);
                tmp = rotateCoords(M, ij3, tmp);
                tmp = rotateCoords(M, ij4, tmp);
                tmp = rotateCoords(M, ij1, tmp);
            }
        }

        return M;
    }

    /**
     * Gets the coordinate of rotation
     * @param from array of 2 positions with corresponding coordinates
     * @param n the size of the matrix
     * @return the rotated coordinates
     */
    private int[] getRotateCoords(int[] from, int n) {
        return new int[] { from[1], n - 1 - from[0] };
    }

    /**
     * Sets the value for the given coordinates.
     * Additionally returns the value that was just overwritten.
     * @param M the matrix
     * @param ij the coordinates to set the value
     * @param value the value to set
     * @return the value that was just overwritten
     */
    private int rotateCoords(Integer[][] M, int[] ij, int value) {
        final int i = ij[0];
        final int j = ij[1];
        int tmp = M[i][j];
        M[i][j] = value;
        return tmp;
    }

}
