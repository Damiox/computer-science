package com.github.damiox.computerscience.exercises.string;

import com.github.damiox.computerscience.Exercise;

/**
 * This algorithm will walk through the string to find out if a given Pattern matches.
 * The idea is to get an initial hashing and then update that hashing while walking through the string.
 * If hashing matches, then we need to make sure if the string matches (hashing are finites,
 * so we need to double check before returning TRUE).
 *
 * I think a best explanation can be found here https://www.youtube.com/watch?v=H4VrKHVG5qI
 *
 * Time Complexity: O(mn) (*)
 * Space Complexity: O(1)
 *
 * *: where m is the length of pattern and n is the length of text,
 * this would be a really worst scenario where all hashing values are equal and the algorithm
 * needs to compare pattern with the substring of text constantly
 *
 * @author dnardelli
 */
public class RabinKarpSubstringSearchExercise implements Exercise<String[], Boolean> {

    private static final long PRIME_NUMBER = 3;

    @Override
    public Boolean solve(String[] params) {
        if (params.length != 2) {
            throw new IllegalArgumentException("Params need to be 2 strings");
        }

        String pattern = params[0];
        String text = params[1];

        if (pattern.length() > text.length()) {
            throw new IllegalStateException("Pattern is greater than text");
        }

        // Getting length...
        int Pn = pattern.length();
        int Tn = text.length();

        // Hashing for pattern
        final long hashPattern = createHash(pattern);

        // Defining aux variables
        int i = 0;

        // initial hash to check
        long hashMatching = createHash(substring(text, i, Pn));

        while (!(hashPattern == hashMatching && substringEquals(pattern, substring(text, i, Pn))) && i < Tn - Pn) {
            hashMatching = recreateHash(hashMatching, text.charAt(i), text.charAt(i + Pn), Pn - 1);
            i++;
        }

        // Did we get match?
        return hashPattern == hashMatching;

        // Manual Debugging for pattern="rap" and text="DADrapDAD"
        // Pn = 3
        // Tn = 9
        // hashPattern = 'r' * 101^0 + 'a' * 101^1 + 'p' * 101^2
        // hashMatching = 'D' * 101^0 + 'A' * 101^1 + 'D' * 101^2
        // hashPattern != hashMatching? yes
        // i < Tn - Pn -> 0 < 6? yes
        // hashMatching = hashStringNeighboor(hashMatching (hOld), 'D' (cOld), 'r', 2)
        // i = 1
        // hashPattern != hashMatching? yes
        // 1 < 6? yes
        // hashMatching = hashStringNeighboor(hashMatching (hOld), 'A' (cOld), 'a', 2)
        // i = 2
        // hashPattern != hashMatching? yes
        // 2 < 6? yes
        // hashMatching = hashStringNeighboor(hashMatching (hOld), 'D' (cOld), 'p', 2)
        // i = 3
        // hashPattern == hashMatching and "rap" is equals to "DADrapDAD".substring(3, 3) ? yes -> TRUE
    }

    private String substring(String S, int idx, int len) {
        if (idx + len > S.length()) {
            throw new IllegalArgumentException("Unable to get substring");
        }

        StringBuilder stringBuilder = new StringBuilder(len);

        for (int i = 0 ; i < len ; i++) {
            stringBuilder.append(S.charAt(i + idx));
        }

        return stringBuilder.toString();
    }

    private boolean substringEquals(String S1, String S2) {
        if (S1.length() != S2.length()) {
            return false;
        }

        for (int i = 0 ; i < S1.length() ; i++) {
            if (S1.charAt(i) != S2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private long createHash(String S) {
        long H = 0;

        for (int i = 0 ; i < S.length() ; i++) {
            char c = S.charAt(i);
            H += (long)c * Math.pow(PRIME_NUMBER, i);
        }

        return H;
    }

    private long recreateHash(long hOld, char cOld, char cNew, int len) {
        return ((hOld - cOld) / PRIME_NUMBER) + (long)(cNew * Math.pow(PRIME_NUMBER, len));
    }

}
