package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;

/**
 * One Away: There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit
 * (or zero edits) away.
 *
 * Solution: We can walk through both strings and if S[i] != T[j] then:
 * 1) diff++;
 * 2) if diff > 1 then return false
 * 3) if m > n then increment j
 * 4) if n > m then increment i
 * 5) if m == n then increment both i and j
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class Question0105Exercise implements Exercise<Question0105Exercise.Params, Boolean> {

    public static class Params {
        public final char[] S;
        public final char[] T;

        Params(char[] S, char[] T) {
            this.S = S;
            this.T = T;
        }
    }

    @Override
    public Boolean solve(Params params) {
        final char[] S = params.S;
        final char[] T = params.T;
        final int n = S.length;
        final int m = T.length;

        // if the difference between the length of both strings is greater than 1,
        // then they will definitively one away
        if (m - n < -1 || m - n > 1) {
            return false;
        }

        int diff = 0;
        int i = 0;
        int j = 0;

        while (diff <= 1 && (i < n && j < m)) {
            if (S[i] != T[j]) {
                if (m == n) {
                    i++;
                    j++;
                } else if (m > n) {
                    j++;
                } else if (n > m) {
                    i++;
                }
                diff++;
            } else {
                i++;
                j++;
            }
        }

        return diff <= 1;
    }

}
