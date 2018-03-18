package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;

/**
 * URLify: Write a method to replace all spaces in a string with '%20:
 * You may assume that the string has sufficient space at the end
 * to hold the additional characters, and that you are given the "true"
 * length of the string. (Note: If implementing in Java, please use a
 * character array so that you can perform this operation in place.)
 *
 * Solution: We can count the number of spaces in S, and then just walk
 * through it in reverse and moving characters, and adding "%20" when
 * a space is found.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class Question0103Exercise implements Exercise<Question0103Exercise.Params, String> {

    private static final char SPACE = ' ';
    private static final char[] SPACE_ENCODED = new char[] {'%','2','0'};

    public static class Params {
        public final char[] S;
        public final int n;

        Params(char[] S, int n) {
            this.S = S;
            this.n = n;
        }
    }

    @Override
    public String solve(Params params) {
        final char[] S = params.S;
        final int n = params.n;

        if (S == null) {
            throw new IllegalArgumentException("S cannot be empty");
        }
        if (n > S.length) {
            throw new IllegalArgumentException("no space in S");
        }

        int c = 0; // number of spaces in S
        for (int i = 0 ; i < n ; i++) {
            if (S[i] == SPACE) {
                c++;
            }
        }

        if (n + c > S.length) {
            throw new IllegalStateException("no sufficient space in S");
        }

        // Adding SPACE_ENCODED for each space...
        for (int i = n - 1 ; i > 0 ; i--) {
            int idx = i + (SPACE_ENCODED.length - 1) * c;

            if (S[i] != SPACE) { // if no space...
                S[idx] = S[i];
            } else { // space!
                for (int j = 0 ; j < SPACE_ENCODED.length ; j++) {
                    S[idx - j] = SPACE_ENCODED[SPACE_ENCODED.length - j - 1];
                }
                c--;
            }
        }

        return new String(S);
    }

}
