package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

public class Question0206ExerciseTest {

    @Test
    public void testSolve() {
        Assert.assertTrue(new Question0206Exercise().solve(Utils.buildNodes("abba")));
        Assert.assertTrue(new Question0206Exercise().solve(Utils.buildNodes("adbda")));
        Assert.assertTrue(new Question0206Exercise().solve(Utils.buildNodes("xxccxx")));
        Assert.assertTrue(new Question0206Exercise().solve(Utils.buildNodes("zxz")));

        Assert.assertFalse(new Question0206Exercise().solve(Utils.buildNodes("zxaz")));
        Assert.assertFalse(new Question0206Exercise().solve(Utils.buildNodes("abc")));
        Assert.assertFalse(new Question0206Exercise().solve(Utils.buildNodes("xwwqx")));
    }

    private static class Utils {
        private static <T> Question0206Exercise.Node buildNodes(String text) {
            Question0206Exercise.Node head = null;
            Question0206Exercise.Node curr = null;

            for (int i = 0 ; i < text.length() ; i++) {
                Question0206Exercise.Node node = new Question0206Exercise.Node(text.charAt(i), null);

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
