package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Question0202ExerciseTest {

    @Test
    public void testSolve() {
        Question0202Exercise.Result<Integer> result;

        result = new Question0202Exercise<Integer>().solve(new Question0202Exercise.Params<>(Question0202ExerciseTest.Utils.buildNodes(Arrays.asList(1, 2, 3)), 0));
        Assert.assertEquals(3L, (long)result.value1);
        Assert.assertEquals(3L, (long)result.value2);

        result = new Question0202Exercise<Integer>().solve(new Question0202Exercise.Params<>(Question0202ExerciseTest.Utils.buildNodes(Arrays.asList(1, 2, 3)), 1));
        Assert.assertEquals(2L, (long)result.value1);
        Assert.assertEquals(2L, (long)result.value2);

        result = new Question0202Exercise<Integer>().solve(new Question0202Exercise.Params<>(Question0202ExerciseTest.Utils.buildNodes(Arrays.asList(1, 2, 3, 1)), 3));
        Assert.assertEquals(1L, (long)result.value1);
        Assert.assertEquals(1L, (long)result.value2);

        result = new Question0202Exercise<Integer>().solve(new Question0202Exercise.Params<>(Question0202ExerciseTest.Utils.buildNodes(Arrays.asList(5, 3, 2, 1, 5, 3, 4)), 0));
        Assert.assertEquals(4L, (long)result.value1);
        Assert.assertEquals(4L, (long)result.value2);

        result = new Question0202Exercise<Integer>().solve(new Question0202Exercise.Params<>(Question0202ExerciseTest.Utils.buildNodes(Arrays.asList(5, 3, 2, 1, 5, 3, 4, 6, 5, 2)), 2));
        Assert.assertEquals(6L, (long)result.value1);
        Assert.assertEquals(6L, (long)result.value2);

        result = new Question0202Exercise<Integer>().solve(new Question0202Exercise.Params<>(Question0202ExerciseTest.Utils.buildNodes(Arrays.asList(1)), 0));
        Assert.assertEquals(1L, (long)result.value1);
        Assert.assertEquals(1L, (long)result.value2);

        result = new Question0202Exercise<Integer>().solve(new Question0202Exercise.Params<>(Question0202ExerciseTest.Utils.buildNodes(Arrays.asList(1, 2)), 0));
        Assert.assertEquals(2L, (long)result.value1);
        Assert.assertEquals(2L, (long)result.value2);

        result = new Question0202Exercise<Integer>().solve(new Question0202Exercise.Params<>(Question0202ExerciseTest.Utils.buildNodes(Arrays.asList(1, 2)), 1));
        Assert.assertEquals(1L, (long)result.value1);
        Assert.assertEquals(1L, (long)result.value2);

        result = new Question0202Exercise<Integer>().solve(new Question0202Exercise.Params<>(Question0202ExerciseTest.Utils.buildNodes(Arrays.asList(1, 2, 3, 4, 5)), 1));
        Assert.assertEquals(4L, (long)result.value1);
        Assert.assertEquals(4L, (long)result.value2);

        result = new Question0202Exercise<Integer>().solve(new Question0202Exercise.Params<>(Question0202ExerciseTest.Utils.buildNodes(Arrays.asList(1, 2, 3, 4, 5)), 0));
        Assert.assertEquals(5L, (long)result.value1);
        Assert.assertEquals(5L, (long)result.value2);

        result = new Question0202Exercise<Integer>().solve(new Question0202Exercise.Params<>(Question0202ExerciseTest.Utils.buildNodes(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19)), 6));
        Assert.assertEquals(13L, (long)result.value1);
        Assert.assertEquals(13L, (long)result.value2);
    }

    private static class Utils {
        private static <T> Question0202Exercise.Node<T> buildNodes(List<T> values) {
            Question0202Exercise.Node<T> head = null;
            Question0202Exercise.Node<T> curr = null;

            for (T value : values) {
                Question0202Exercise.Node<T> node = new Question0202Exercise.Node<T>(value, null);

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
    }

}
