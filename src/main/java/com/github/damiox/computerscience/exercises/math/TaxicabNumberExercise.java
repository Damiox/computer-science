package com.github.damiox.computerscience.exercises.math;

import com.github.damiox.computerscience.Exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This exercise is about finding all positive integer solutions under 1,000 to a^3 + b^3 = c^3 + d^3
 * For more information about Taxicab numbers, please see https://en.wikipedia.org/wiki/Taxicab_number
 * Found exercise in CTCI (page 23)
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 * @author dnardelli
 */
class TaxicabNumberExercise implements Exercise<Integer, Map<Long, List<TaxicabNumberExercise.Pair>>> {

    public Map<Long, List<Pair>> solve(Integer n) {
        long t1 = System.currentTimeMillis();

        Map<Long, List<Pair>> hashedTaxicabs = new HashMap<>(n / 2);

        System.out.println("n = " + n);

        for (int i = 1 ; i <= n ; i++) {
            for (int j = i ; j <= n ; j++) {
                long taxicab = (long)(Math.pow(i, 3) + Math.pow(j, 3));
                List<Pair> pairs = hashedTaxicabs.computeIfAbsent(taxicab, k -> new ArrayList<>());
                pairs.add(new Pair(i, j));
            }
        }

        System.out.println("took " + (System.currentTimeMillis() - t1) + " ms");

        return hashedTaxicabs.entrySet().stream()
                .filter(t -> t.getValue().size() >= 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static class Pair {
        final int i;
        final int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}
