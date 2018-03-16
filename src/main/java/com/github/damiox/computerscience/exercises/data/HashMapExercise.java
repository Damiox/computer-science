package com.github.damiox.computerscience.exercises.data;

import com.github.damiox.computerscience.Exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * HashMap Implementation.
 *
 * @author dnardelli
 */
public class HashMapExercise implements Exercise<List<String[]>, HashMapExercise.HashMap> {

    @Override
    public HashMap solve(List<String[]> params) {
        return new HashMap();
    }

    public static class HashMap {

        private static final int PRIME = 101;
        private static final int CAPACITY = 100;
        private List<Pair>[] keys = new List[CAPACITY];

        public void add(String key, String value) {
            final int index = this.hash(key) % CAPACITY;

            // Initializing list of values...
            if (keys[index] == null) {
                keys[index] = new LinkedList<>();
            }

            keys[index].add(new Pair(key, value));
        }

        public int size() {
            int length = 0;
            // it would be more efficient to keep the size buffered
            for (int i = 0 ; i < CAPACITY ; i++) {
                if (keys[i] != null) {
                    length += keys[i].size();
                }
            }
            return length;
        }

        public boolean remove(String key) {
            if (key == null) {
                throw new IllegalArgumentException("key cannot be null");
            }

            final int index = this.hash(key) % CAPACITY;
            final List<Pair> values = keys[index];
            if (values != null) {
                // Sequentially looking for the values in the list...
                for (int i = 0; i < values.size(); i++) {
                    if (key.equals(values.get(i).key)) {
                        values.remove(i);
                        return true;
                    }
                }
            }

            return false;
        }

        public String get(String key) {
            final Pair pair = this.getPair(key);
            return pair != null ? pair.value : null;
        }

        public boolean containsKey(String key) {
            return this.getPair(key) != null;
        }

        private Pair getPair(String key) {
            if (key == null) {
                throw new IllegalArgumentException("key cannot be null");
            }

            Pair found = null;

            final int index = this.hash(key) % CAPACITY;
            final List<Pair> values = keys[index];
            if (values != null) {
                // Sequentially looking for the values in the list...
                for (int i = 0; i < values.size(); i++) {
                    if (key.equals(values.get(i).key)) {
                        found = values.get(i);
                        break;
                    }
                }
            }

            return found;
        }

        public int hash(String key) {
            int hashcode = 0;
            for (int i = 0 ; i < key.length() ; i++) {
                hashcode += key.charAt(i) * (int)Math.pow(PRIME, i);
            }
            return hashcode;
        }

        private static class Pair {
            public final String key;
            public final String value;

            Pair(String key, String value) {
                this.key = key;
                this.value = value;
            }
        }

    }

}
