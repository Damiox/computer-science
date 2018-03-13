package com.github.damiox.computerscience.exercises.data;

import com.github.damiox.computerscience.Exercise;

/**
 * String Builder Implementation
 *
 * @author dnardelli
 */
public class StringBuilderExercise implements Exercise<String[], StringBuilderExercise.StringBuilder> {

    @Override
    public StringBuilder solve(String[] params) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0 ; i < params.length ; i++) {
            stringBuilder.append(params[i]);
        }

        return stringBuilder;
    }

    public static class StringBuilder {
        private static final double FACTOR = 2.0;
        private static final int INITIAL_CAPACITY = 10;

        private String[] S;
        private int len;
        private int chars;

        public StringBuilder() {
            this(INITIAL_CAPACITY);
        }

        public StringBuilder(int capacity) {
            this.S = new String[capacity];
            this.len = 0;
        }

        public int size() {
            return this.len;
        }

        public void append(String str) {
            if (S.length == len) {
                resize();
            }
            S[len++] = str;
            chars += str.length();
        }

        @Override
        public String toString() {
            char[] C = new char[chars];
            for (int i = 0, j = 0 ; i < len ; i++) {
                for (int c = 0 ; c < S[i].length() ; c++, j++) {
                    C[j] = S[i].charAt(c);
                }
            }

            return new String(C, 0, chars);
        }

        private void resize() {
            String[] B = new String[(int)(len * FACTOR)];
            for (int i = 0 ; i < len ; i++) {
                B[i] = S[i];
            }
            this.S = B;
        }

    }

}
