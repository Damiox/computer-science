package com.github.damiox.computerscience.exercises.math;

import com.github.damiox.computerscience.Exercise;

/**
 * Suppose you were asked to write a function to check if the value of a
 * binary number (passed as a string) equals the hexadecimal representation
 * of a string.
 *
 * Time Complexity: O(b * h) where b and h are the length of both strings respectively
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class CheckBinaryAndHexMatchExercise implements Exercise<CheckBinaryAndHexMatchExercise.Params, Boolean> {

    public static class Params {
        public final String binary;
        public final String hex;

        public Params(String binary, String hex) {
            this.binary = binary;
            this.hex = hex;
        }
    }

    @Override
    public Boolean solve(Params params) {
        final String binary = params.binary;
        final String hex = params.hex;

        return convertStrToBase(binary, 2) == convertStrToBase(hex, 16);
    }

    private int convertStrToBase(String numberStr, int base) {
        final String HEXA = "0123456789ABCDEF";
        if (base != 2 && base != 16) {
            throw new IllegalArgumentException("convertStrToBase was only tested for base 2 and 16");
        }

        int number = 0;
        for (int i = 0 ; i < numberStr.length() ; i++) {
            int c = numberStr.charAt(i);
            if (base == 16) {
                c = HEXA.indexOf(c);
            } else {
                c -= '0';
            }
            number += c * Math.pow(base, numberStr.length() - i - 1);
        }

        return number;
    }

}
