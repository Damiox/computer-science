package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Question0208ExerciseTest {

    @Test
    public void testSolve() {
        Question0208Exercise.Node<Integer> N;

        N = Utils.makeCircular(Utils.buildNodes(Arrays.asList(1, 2, 3, 4, 5, 6)), 3);
        Assert.assertEquals(Utils.getNodeFromList(N, 3), new Question0208Exercise<Integer>().solve(N));

        N = Utils.makeCircular(Utils.buildNodes(Arrays.asList(9, 8, 8, 9, 7, 6, 5, 4, 3, 5, 4)), 7);
        Assert.assertEquals(Utils.getNodeFromList(N, 7), new Question0208Exercise<Integer>().solve(N));

        N = Utils.makeCircular(Utils.buildNodes(Arrays.asList(1, 2, 3, 4, 5, 6)), 0);
        Assert.assertEquals(Utils.getNodeFromList(N, 0), new Question0208Exercise<Integer>().solve(N));

        N = Utils.makeCircular(Utils.buildNodes(Arrays.asList(1, 2, 3)), 2);
        Assert.assertEquals(Utils.getNodeFromList(N, 2), new Question0208Exercise<Integer>().solve(N));
    }

    private static class Utils {
        private static <T> Question0208Exercise.Node<T> buildNodes(List<T> values) {
            Question0208Exercise.Node<T> head = null;
            Question0208Exercise.Node<T> curr = null;

            for (T value : values) {
                Question0208Exercise.Node<T> node = new Question0208Exercise.Node<T>(value, null);

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

        private static <T> Question0208Exercise.Node<T> getNodeFromList(Question0208Exercise.Node<T> N, int n) {
            for (int i = 0 ; i < n ; i++) {
                N = N.next;
            }

            return N;
        }

        private static <T> Question0208Exercise.Node<T> makeCircular(Question0208Exercise.Node<T> N, int n) {
            Question0208Exercise.Node<T> curr = N;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = getNodeFromList(N, n);
            return N;
        }
    }

}
