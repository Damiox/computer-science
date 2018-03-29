package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Question0205ExerciseTest {

    @Test
    public void testSolve() {
        // reverse order
        Assert.assertEquals(
            Arrays.asList(2, 1, 9),
            Utils.getValues(
                new Question0205Exercise().solve(
                    new Question0205Exercise.Params(Utils.buildNodes(Arrays.asList(7, 1, 6)), Utils.buildNodes(Arrays.asList(5, 9, 2)), false)
                )
            )
        );
        Assert.assertEquals(
            Arrays.asList(0, 1, 2, 1),
            Utils.getValues(
                new Question0205Exercise().solve(
                    new Question0205Exercise.Params(Utils.buildNodes(Arrays.asList(0, 2, 1, 1)), Utils.buildNodes(Arrays.asList(0, 9)), false)
                )
            )
        );

        // forward order
        Assert.assertEquals(
            Arrays.asList(9, 1, 2),
            Utils.getValues(
                new Question0205Exercise().solve(
                    new Question0205Exercise.Params(Utils.buildNodes(Arrays.asList(6, 1, 7)), Utils.buildNodes(Arrays.asList(2, 9, 5)), true)
                )
            )
        );
        Assert.assertEquals(
            Arrays.asList(2, 0, 0),
            Utils.getValues(
                new Question0205Exercise().solve(
                    new Question0205Exercise.Params(Utils.buildNodes(Arrays.asList(1, 5, 0)), Utils.buildNodes(Arrays.asList(0, 5, 0)), true)
                )
            )
        );
    }

    private static class Utils {
        private static <T> Question0205Exercise.Node buildNodes(List<Integer> digits) {
            Question0205Exercise.Node head = null;
            Question0205Exercise.Node curr = null;

            for (int digit : digits) {
                Question0205Exercise.Node node = new Question0205Exercise.Node(digit, null);

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

        private static List<Integer> getValues(final Question0205Exercise.Node head) {
            List<Integer> values = new LinkedList<>();
            Question0205Exercise.Node curr = head;

            while (curr != null) {
                values.add(curr.digit);
                curr = curr.next;
            }

            return values;
        }
    }
}
