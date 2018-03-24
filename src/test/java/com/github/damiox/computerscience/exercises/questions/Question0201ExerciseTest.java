package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Question0201ExerciseTest {

    @Test
    public void testSolve() {
        Question0201Exercise.Result result;

        result = new Question0201Exercise<Integer>().solve(Utils.buildNodes(Arrays.asList(5, 3, 2, 1, 5, 3, 4, 6, 5, 2)));
        Assert.assertEquals(Arrays.asList(5, 3, 2, 1, 4, 6), Utils.getValues(result.deduped1));
        Assert.assertEquals(Arrays.asList(5, 3, 2, 1, 4, 6), Utils.getValues(result.deduped2));

        result = new Question0201Exercise<Integer>().solve(Utils.buildNodes(Collections.singletonList(1)));
        Assert.assertEquals(Collections.singletonList(1), Utils.getValues(result.deduped1));
        Assert.assertEquals(Collections.singletonList(1), Utils.getValues(result.deduped2));

        result = new Question0201Exercise<Integer>().solve(Utils.buildNodes(Arrays.asList(1, 2, 3)));
        Assert.assertEquals(Arrays.asList(1, 2, 3), Utils.getValues(result.deduped1));
        Assert.assertEquals(Arrays.asList(1, 2, 3), Utils.getValues(result.deduped2));

        result = new Question0201Exercise<Integer>().solve(Utils.buildNodes(Arrays.asList(1, 2, 3, 1)));
        Assert.assertEquals(Arrays.asList(1, 2, 3), Utils.getValues(result.deduped1));
        Assert.assertEquals(Arrays.asList(1, 2, 3), Utils.getValues(result.deduped2));

        result = new Question0201Exercise<Integer>().solve(Utils.buildNodes(Arrays.asList(1, 2, 3, 1, 1, 2, 1, 3, 2, 1, 1, 1, 1, 2, 3, 4, 1, 1, 2, 3)));
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), Utils.getValues(result.deduped1));
        Assert.assertEquals(Arrays.asList(1, 2, 3, 4), Utils.getValues(result.deduped2));

        result = new Question0201Exercise<Integer>().solve(Utils.buildNodes(Arrays.asList(1, 1, 1, 1, 1)));
        Assert.assertEquals(Collections.singletonList(1), Utils.getValues(result.deduped1));
        Assert.assertEquals(Collections.singletonList(1), Utils.getValues(result.deduped2));
    }

    private static class Utils {
        private static <T> Question0201Exercise.Node<T> buildNodes(List<T> values) {
            Question0201Exercise.Node<T> head = null;
            Question0201Exercise.Node<T> curr = null;

            for (T value : values) {
                Question0201Exercise.Node node = new Question0201Exercise.Node<T>(value, null, null);

                if (head == null) {
                    head = node;
                    curr = node;
                } else {
                    curr.next = node;
                    node.prev = curr;
                    curr = curr.next;
                }
            }

            return head;
        }

        private static <T> List<T> getValues(final Question0201Exercise.Node<T> head) {
            List<T> values = new LinkedList<>();
            Question0201Exercise.Node<T> curr = head;

            while (curr != null) {
                values.add(curr.data);
                curr = curr.next;
            }

            return values;
        }
    }

}
