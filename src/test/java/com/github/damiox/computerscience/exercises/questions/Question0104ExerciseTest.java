package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

public class Question0104ExerciseTest {

    @Test
    public void testSolve() {
        Assert.assertTrue(new Question0104Exercise().solve("Tact Coa"));
        Assert.assertTrue(new Question0104Exercise().solve("nana"));
        Assert.assertTrue(new Question0104Exercise().solve("Amigo no gima"));
        Assert.assertTrue(new Question0104Exercise().solve("311"));
        Assert.assertTrue(new Question0104Exercise().solve("neaNa"));

        Assert.assertFalse(new Question0104Exercise().solve("Damian"));
        Assert.assertFalse(new Question0104Exercise().solve("en"));
        Assert.assertFalse(new Question0104Exercise().solve("Nada"));
        Assert.assertFalse(new Question0104Exercise().solve("NAEMA"));
    }

}
