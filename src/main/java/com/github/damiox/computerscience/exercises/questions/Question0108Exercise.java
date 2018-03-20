package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;

/**
 * Zero Matrix: Write an algorithm such that if an element
 * in an MxN matrix is 0, its entire row and column are set to O.
 *
 * Solution: for {x,y} coordinates, we need to set to 0 the
 * following coordinates:
 * a) M[0..m][y] = 0
 * b) M[x][0..n] = 0
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class Question0108Exercise implements Exercise<Question0108Exercise.Params, Integer[][]> {

    public static class Params {
        public final Integer[][] M;
        public final int[] xy;

        Params(Integer[][] M, int[] xy) {
            this.M = M;
            this.xy = xy;
        }
    }

    @Override
    public Integer[][] solve(Params params) {
        final Integer[][] M = params.M;
        final int[] xy = params.xy;

        if (M.length == 0) {
            throw new IllegalArgumentException("Invalid Matrix");
        }

        final int m = M.length;
        final int n = M[0].length;
        final int x = xy[0];
        final int y = xy[1];

        for (int i = 0 ; i < m ; i++) {
            M[i][y] = 0;
        }
        for (int j = 0 ; j < n ; j++) {
            M[x][j] = 0;
        }

        return M;
    }

}
