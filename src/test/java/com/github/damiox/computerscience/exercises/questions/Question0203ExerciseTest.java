package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question0203ExerciseTest {

    @Test
    public void testSolve() {
        Question0203Exercise.Node<Integer> node;

        node = Utils.buildNodes(Arrays.asList(1, 2, 3));
        Assert.assertTrue(new Question0203Exercise<Integer>().solve(new Question0203Exercise.Params<>(node, 2)));
        Assert.assertEquals(Arrays.asList(1, 3), Utils.getValues(node));

        node = Utils.buildNodes(Arrays.asList(1, 2, 3));
        Assert.assertFalse(new Question0203Exercise<Integer>().solve(new Question0203Exercise.Params<>(node, 1)));
        Assert.assertEquals(Arrays.asList(1, 2, 3), Utils.getValues(node));

        node = Utils.buildNodes(Arrays.asList(1, 2, 3));
        Assert.assertFalse(new Question0203Exercise<Integer>().solve(new Question0203Exercise.Params<>(node, 3)));
        Assert.assertEquals(Arrays.asList(1, 2, 3), Utils.getValues(node));
    }

    private static class Utils {
        private static <T> Question0203Exercise.Node<T> buildNodes(List<T> values) {
            Question0203Exercise.Node<T> head = null;
            Question0203Exercise.Node<T> curr = null;

            for (T value : values) {
                Question0203Exercise.Node<T> node = new Question0203Exercise.Node<T>(value, null);

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

        private static <T> List<T> getValues(final Question0203Exercise.Node<T> head) {
            List<T> values = new LinkedList<>();
            Question0203Exercise.Node<T> curr = head;

            while (curr != null) {
                values.add(curr.data);
                curr = curr.next;
            }

            return values;
        }
    }

}
