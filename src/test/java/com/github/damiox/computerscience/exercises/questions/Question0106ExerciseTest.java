package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

public class Question0106ExerciseTest {

    @Test
    public void testSolve() {
        Assert.assertEquals("a2b1c5a3", new Question0106Exercise().solve("aabcccccaaa"));
        Assert.assertEquals("a", new Question0106Exercise().solve("a"));
        Assert.assertEquals("ab", new Question0106Exercise().solve("ab"));
        Assert.assertEquals("abc", new Question0106Exercise().solve("abc"));
        Assert.assertEquals("aaaabc", new Question0106Exercise().solve("aaaabc"));
        Assert.assertEquals("a5b1c1", new Question0106Exercise().solve("aaaaabc"));

    }

}
