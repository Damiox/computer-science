package com.github.damiox.computerscience.exercises.string;

import com.github.damiox.computerscience.Exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a smaller string p and a bigger string b, design an algorithm to find
 * all permutations of the shorter string within the longer one. Print the
 * location of each permutation.
 *
 * Time Complexity: O(n) where n is the length of string B
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class StringContainsPermutedPatternExercise implements Exercise<StringContainsPermutedPatternExercise.Params, List<Integer>> {

    private static final int PRIME_NUMER = 101;

    public static class Params {
        public final String text;
        public final String pattern;

        public Params(String text, String pattern) {
            this.text = text;
            this.pattern = pattern;
        }
    }

    @Override
    public List<Integer> solve(Params params) {
        final String text = params.text;
        final String pattern = params.pattern;
        final int m = pattern.length();

        if (text.length() < pattern.length()) {
            throw new IllegalArgumentException("pattern cannot be smaller than text");
        }

        int patternHashed = hash(pattern);

        List<Integer> positions = new ArrayList<>();

        int textHashed = hash(substring(text, 0, m));
        if (textHashed == patternHashed) {
            // special case
            positions.add(0);
        }

        for (int i = m ; i < text.length() ; i++) {
            textHashed = rehash(text, textHashed, i - m, i);
            if (textHashed == patternHashed) {
                positions.add(i - m + 1);
            }
        }

        return positions;

        // Manual Debugging for text="mandioca" and pattern="dni"
        // 'm' = 1, 'a' = 2, 'n' = 3, 'd' = 4, 'i' = 5, 'o' = 6, 'c' = 7
        // patternHashed = 'd' + 'n' + 'i' = 4 + 3 + 5 = 12
        // textHashed = 'm' + 'a' + 'n' = 1 + 2 + 3 = 6
        // i = 3
        // textHashed = 6 - 'm' + 'd' = 6 - 1 + 4 = 9
        // i = 4
        // textHashed = 9 - 'a' + 'i' = 9 - 2 + 5 = 12 -> found it on position 2!
    }

    private int hash(String S) {
        int hash = 0;
        for (int i = 0 ; i < S.length() ; i++) {
            hash += PRIME_NUMER * S.charAt(i);
        }
        return hash;
    }

    private int rehash(String S, int hash, int i, int j) {
        return hash - PRIME_NUMER * S.charAt(i) + PRIME_NUMER * S.charAt(j);
    }

    private String substring(String S, int idx, int n) {
        StringBuilder stringBuilder = new StringBuilder(n);

        for (int i = idx ; i < idx + n ; i++) {
            stringBuilder.append(S.charAt(i));
        }

        return stringBuilder.toString();
    }

}
