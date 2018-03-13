package com.github.damiox.computerscience.exercises.data;

import com.github.damiox.computerscience.Exercise;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Array List Implementation.
 *
 * @author dnardelli
 */
public class ArrayListExercise implements Exercise<Integer[], ArrayListExercise.ArrayList> {

    @Override
    public ArrayList solve(Integer[] params) {
        ArrayList arrayList = new ArrayList();

        for (int i = 0 ; i < params.length ; i++) {
            arrayList.add(params[i]);
        }

        arrayList.set(50, -100);

        return arrayList;
    }

    public static class ArrayList implements Iterable<Integer> {
        private static final double FACTOR = 2.0;
        private static final int INITIAL_CAPACITY = 10;

        private int[] A;
        private int n;

        public ArrayList() {
            this(INITIAL_CAPACITY);
        }

        public ArrayList(int capacity) {
            this.A = new int[capacity];
            this.n = 0;
        }

        public int size() {
            return this.n;
        }

        public int getCapacity() {
            return this.A.length;
        }

        public int get(int i) {
            if (i >= n) {
                throw new IllegalArgumentException("Out of bounds");
            }
            return A[i];
        }

        public void set(int i, int value) {
            if (i >= n) {
                throw new IllegalArgumentException("Out of bounds");
            }
            A[i] = value;
        }

        public void add(int value) {
            if (A.length == n) {
                resize();
            }
            A[n++] = value;
        }

        public void remove(int value) {
            // O(n)
            for (int i = 0 ; i < n ; i++) {
                if (A[i] == value) {
                    A[i] = A[n--];
                }
            }
        }

        public boolean contains(int value) {
            for (int i = 0 ; i < n ; i++) {
                if (A[i] == value) {
                    return true;
                }
            }

            return false;
        }

        private void resize() {
            int[] B = new int[(int)(n * FACTOR)];
            for (int i = 0 ; i < n ; i++) {
                B[i] = A[i];
            }
            this.A = B;
        }

        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                private int i = 0;

                @Override
                public boolean hasNext() {
                    return i < n;
                }

                @Override
                public Integer next() {
                    return A[i++];
                }
            };
        }

        @Override
        public void forEach(Consumer<? super Integer> action) {
            throw new UnsupportedOperationException("not supported");
        }

        @Override
        public Spliterator<Integer> spliterator() {
            throw new UnsupportedOperationException("not supported");
        }
    }

}
