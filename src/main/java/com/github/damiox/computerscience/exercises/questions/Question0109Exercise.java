package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;
import com.github.damiox.computerscience.exercises.string.RabinKarpSubstringSearchExercise;

/**
 * String Rotation: Assume you have a method isSubstring which checks if
 * one word is a substring of another. Given two strings, 51 and 52,
 * write code to check if 52 is a rotation of 51 using only one call
 * to isSubstring (e.g.,"waterbottle" is a rotation of "erbottlewat").
 *
 * Solution: we need to take into account that s1 is a rotation of s2
 * iff s2 is composed by a suffix of s1 and a preffix of s1.
 * Which means that if s1 is x+y (preffix+suffix), then s2 would be
 * y+x (suffix+preffix) and that if we concatenate s2 to itself twice,
 * then that would mean y+x+y+x which means that x+y would be clearly
 * identified as a substring of y+x+y+x
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author dnardelli
 */
public class Question0109Exercise implements Exercise<Question0109Exercise.Params, Boolean> {

    public static class Params {
        public final char[] S1;
        public final char[] S2;

        Params(char[] S1, char[] S2) {
            this.S1 = S1;
            this.S2 = S2;
        }
    }

    @Override
    public Boolean solve(Params params) {
        final char[] S1 = params.S1;
        final char[] S2 = params.S2;

        if (S1.length != S2.length) {
            return false;
        }

        final int n = S1.length;
        final char[] S3 = new char[n * 2];

        for (int i = 0 ; i < n ; i++) {
            S3[i] = S2[i];
            S3[i + n] = S2[i];
        }

        return isSubstring(S3, S1);
    }

    private boolean isSubstring(char[] S1, char[] S2) {
        return new RabinKarpSubstringSearchExercise().solve(new String[] { new String(S2), new String(S1) });
    }

}
