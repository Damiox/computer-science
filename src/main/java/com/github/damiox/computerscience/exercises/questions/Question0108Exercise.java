package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;

/**
 * Zero Matrix: Write an algorithm such that if an element
 * in an MxN matrix is 0, its entire row and column are set to O.
 *
 * Solution: walk through the Matrix (M) and queue all rows and columns
 * that need to be zeroed out.
 * Then walk through all rows and cols and zero the row/col,
 * we need to set to 0 the following coordinates:
 * a) M[0..m][y] = 0
 * b) M[x][0..n] = 0
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(m + n)
 *
 * Alternative solution: there's a tricky solution that uses space complexity of
 * O(1) which means to do the following:
 * a) check if row[0] has any zero value in any column -> have a flag row0=true if any
 * b) check if col[0] has any zero value in any row -> have a flag col0=true if any
 * c) walk through the rest of matrix, and if any 0 is found, mark {i,0} and {0,j}
 * d) walk through row[0] in matrix, and when any 0, then set all row to 0
 * e) walk through col[0] in matrix, and when any 0, then set all col to 0
 * f) check if row0 is true -> then zero all the row0 to 0
 * g) check if col0 is true -> then zero all the col0 to 0
 *
 * @author dnardelli
 */
public class Question0108Exercise implements Exercise<Integer[][], Integer[][]> {

    @Override
    public Integer[][] solve(Integer[][] M) {
        if (M == null || M.length == 0) {
            throw new IllegalArgumentException("Invalid Matrix");
        }

        final int m = M.length;
        final int n = M[0].length;
        final boolean[] rows = new boolean[m];
        final boolean[] cols = new boolean[n];

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (M[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0 ; i < m ; i++) {
            if (rows[i]) {
                this.zeroRow(M, i, n);
            }
        }
        for (int j = 0 ; j < n ; j++) {
            if (cols[j]) {
                this.zeroColumn(M, j, m);
            }
        }

        return M;
    }

    private void zeroRow(Integer[][] M, int x, int n) {
        for (int j = 0 ; j < n ; j++) {
            M[x][j] = 0;
        }
    }

    private void zeroColumn(Integer[][] M, int y, int m) {
        for (int i = 0 ; i < m ; i++) {
            M[i][y] = 0;
        }
    }

}
