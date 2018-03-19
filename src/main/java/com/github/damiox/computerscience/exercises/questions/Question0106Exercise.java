package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;

/**
 * String Compression: Implement a method to perform basic string
 * compression using the counts of repeated characters. For example,
 * the string aabcccccaaa would become a2b1c5a3. If the "compressed"
 * string would not become smaller than the original string, your
 * method should return the original string. You can assume the
 * string has only uppercase and lowercase letters (a - z).
 *
 * Solution: walk through S and count repeated chars
 * 1) add char+count when different
 * 2) if C.length >= S.length, then return S
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author dnardelli
 */
public class Question0106Exercise implements Exercise<String, String> {

    @Override
    public String solve(String string) {
        final char[] S = string.toCharArray();
        final int n = S.length;
        if (n <= 1) {
            return new String(S);
        }

        char[] C = new char[n];
        char prev = S[0];
        int count = 1;
        int j = 0;

        for (int i = 1 ; i < n ; i++) {
            char curr = S[i];

            if (curr == prev) {
                count++;
            } else {
                j = compress(C, j, prev, count);
                if (j == -1) {
                    return new String(S); // C is bigger than S
                }
                prev = curr;
                count = 1;
            }
        }

        // adding the last digit
        j = compress(C, j, prev, count);
        if (j == -1) {
            return new String(S); // C is bigger than S
        }

        return new String(C, 0, j);
    }

    private int compress(char[] C, int i, char c, int count) {
        if (i >= C.length - 2) {
            return -1; // won't add because compression is not effective in this string
        }
        C[i++] = c;
        C[i++] = Character.forDigit(count, 10);
        return i;
    }

}
