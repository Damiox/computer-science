package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Question0207ExerciseTest {

    @Test
    public void testSolve() {
        Question0207Exercise.Node<Integer> A, B;

        // A > B
        A = Utils.buildNodes(Arrays.asList(1, 2, 1, 2, 3, 6, 7, 8, 9));
        B = Utils.getNodeFromList(A, 4);
        Assert.assertEquals(B, new Question0207Exercise().solve(new Question0207Exercise.Params<>(A, B)));

        // A < B
        A = Utils.buildNodes(Arrays.asList(1, 2, 3, 4));
        B = Utils.addToList(Utils.buildNodes(Arrays.asList(1, 2, 3)), Utils.getNodeFromList(A, 1));
        Assert.assertEquals(Utils.getNodeFromList(A, 1), new Question0207Exercise().solve(new Question0207Exercise.Params<>(A, B)));

        // A = B
        A = Utils.buildNodes(Arrays.asList(1, 2, 3, 4));
        Assert.assertEquals(A, new Question0207Exercise().solve(new Question0207Exercise.Params<>(A, A)));
    }

    private static class Utils {
        private static <T> Question0207Exercise.Node<T> buildNodes(List<T> values) {
            Question0207Exercise.Node<T> head = null;
            Question0207Exercise.Node<T> curr = null;

            for (T value : values) {
                Question0207Exercise.Node<T> node = new Question0207Exercise.Node<T>(value, null);

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

        private static <T> Question0207Exercise.Node<T> addToList(Question0207Exercise.Node<T> N1, Question0207Exercise.Node<T> N2) {
            Question0207Exercise.Node<T> currN1 = N1;
            while (currN1.next != null) {
                currN1 = currN1.next;
            }
            currN1.next = N2;

            return currN1;
        }

        private static <T> Question0207Exercise.Node<T> getNodeFromList(Question0207Exercise.Node<T> N, int n) {
            for (int i = 0 ; i < n ; i++) {
                N = N.next;
            }

            return N;
        }
    }

}
