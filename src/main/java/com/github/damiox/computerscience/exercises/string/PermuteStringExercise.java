package com.github.damiox.computerscience.exercises.string;

import com.github.damiox.computerscience.Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Permutes an string recursively.
 * If the String is composed by c0 + c1 + ... + cN where 'cX' is a character in the string at position X
 * then we permute a substring composed by c0 + c1 + ... c(n-1) and with that result we add the cN character
 * in the different positions of the permutations obtained from the substring.
 *
 * Time Complexity: O(n * n!) where n is the length of the passed in string
 * Space Complexity: O(n)
 *
 * @author dnardelli
 */
public class PermuteStringExercise implements Exercise<String, List<String>> {

    @Override
    public List<String> solve(String S) {
        return permute(S);
    }

    private List<String> permute(String S) {
        if (S.length() == 1) {
            return Collections.singletonList(S);
        }

        String sub = substring(S, 0, S.length() - 1);
        String letter = Character.toString(S.charAt(S.length() - 1));

        List<String> permutes = new ArrayList<>();

        List<String> subPermutations = permute(sub);
        for (String subPermutation : subPermutations) {
            permutes.add(letter + subPermutation);
            for (int i = 1 ; i < subPermutation.length() ; i++) {
                permutes.add(substring(subPermutation, 0, i) + letter + substring(subPermutation, i, subPermutation.length() - i));
            }
            permutes.add(subPermutation + letter);
        }

        return permutes;

        // Manual Debugging for "ab"
        // -> permute("ab")
        // -> sub = "a"
        // -> letter = "b"
        // -> permute("a")
        //   -> [a]
        // -> add "" + "b" + "a"
        // -> add "a" + "b" + ""
        // returns ["ba", "ba]
    }

    private String substring(String S, int idx, int n) {
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = idx ; i < idx + n ; i++) {
            stringBuilder.append(S.charAt(i));
        }
        return stringBuilder.toString();
    }

}
