package com.github.damiox.computerscience.exercises.data;

import org.junit.Assert;
import org.junit.Test;

public class StringBuilderExerciseTest {

    @Test
    public void testSolve() {
        StringBuilderExercise.StringBuilder stringBuilder =
            new StringBuilderExercise().solve(new String[] { "My", " ", "name", " ", "is", " <please enter name here> ", ":)"});

        stringBuilder.append(" BYE");
        stringBuilder.append(" lol");

        Assert.assertEquals(9, stringBuilder.size());
        Assert.assertEquals("My name is <please enter name here> :) BYE lol", stringBuilder.toString());
    }

}
