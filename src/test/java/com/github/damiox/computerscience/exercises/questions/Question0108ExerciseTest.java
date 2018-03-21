package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

public class Question0108ExerciseTest {

    @Test
    public void testSolve() {
        // 0 1 1 1     0 0 0 0
        // 1 0 1 1     0 0 0 0
        // 1 1 1 1 ->  0 0 1 1
        // 1 1 1 1     0 0 1 1
        // 1 1 1 1     0 0 1 1
        Assert.assertArrayEquals(new Integer[][] { {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}, {0, 0, 1, 1} }, new Question0108Exercise().solve(new Integer[][] { {0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1} }));

        // 1 1 1 1     1 0 0 1
        // 1 1 0 1 ->  0 0 0 0
        // 1 0 1 1     0 0 0 0
        // 1 1 1 1     1 0 0 1
        Assert.assertArrayEquals(new Integer[][] { {1, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 1} }, new Question0108Exercise().solve(new Integer[][] { {1, 1, 1, 1}, {1, 1, 0, 1}, {1, 0, 1, 1}, {1, 1, 1, 1} }));
    }

}
