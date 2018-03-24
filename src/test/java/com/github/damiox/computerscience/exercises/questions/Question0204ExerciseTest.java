package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question0204ExerciseTest {

    @Test
    public void testSolve() {
        Assert.assertEquals(Arrays.asList(1, 2, 3, 5, 8, 5, 10), Utils.getValues(new Question0204Exercise<Integer>().solve(new Question0204Exercise.Params<>(Utils.buildNodes(Arrays.asList(3, 5, 8, 5, 10, 2, 1)), 5, Integer::compareTo))));
        Assert.assertEquals(Arrays.asList(2, 1, 4, 3), Utils.getValues(new Question0204Exercise<Integer>().solve(new Question0204Exercise.Params<>(Utils.buildNodes(Arrays.asList(4, 3, 1, 2)), 3, Integer::compareTo))));
        Assert.assertEquals(Arrays.asList(1, 3, 0, 5, 6, 9, 4), Utils.getValues(new Question0204Exercise<Integer>().solve(new Question0204Exercise.Params<>(Utils.buildNodes(Arrays.asList(0, 3, 1, 5, 6, 9, 4)), 4, Integer::compareTo))));
    }

    private static class Utils {
        private static <T> Question0204Exercise.Node<T> buildNodes(List<T> values) {
            Question0204Exercise.Node<T> head = null;
            Question0204Exercise.Node<T> curr = null;

            for (T value : values) {
                Question0204Exercise.Node<T> node = new Question0204Exercise.Node<T>(value, null);

                if (head == null) {
                    head = node;
                    curr = node;
                } else {
                    curr.next = node;
                    curr = curr.next;
                }
            }

            return head;
        }

        private static <T> List<T> getValues(final Question0204Exercise.Node<T> head) {
            List<T> values = new LinkedList<>();
            Question0204Exercise.Node<T> curr = head;

            while (curr != null) {
                values.add(curr.data);
                curr = curr.next;
            }

            return values;
        }
    }
}
