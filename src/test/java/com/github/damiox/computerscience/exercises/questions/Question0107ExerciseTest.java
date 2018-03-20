package com.github.damiox.computerscience.exercises.questions;

import org.junit.Assert;
import org.junit.Test;

public class Question0107ExerciseTest {

    @Test
    public void testSolve() {
        // 01, 02, 03, 04       13 09 05 01
        // 05, 06, 07, 08  -->  14 10 06 02
        // 09, 10, 11, 12       15 11 07 03
        // 13, 14, 15, 16       16 12 08 04
        Assert.assertArrayEquals(new Integer[][] { {13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4} }, new Question0107Exercise().solve(new Integer[][] { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12 }, {13, 14, 15, 16} }));

        // 01, 02, 03, 04, 05        21 16 11 06 01
        // 06, 07, 08, 09, 10        22 17 12 07 02
        // 11, 12, 13, 14, 15  -->   23 18 13 08 03
        // 16, 17, 18, 19, 20        24 19 14 09 04
        // 21, 22, 23, 24, 25        25 20 15 10 05
        Assert.assertArrayEquals(new Integer[][] { {21, 16, 11, 6, 1}, {22, 17, 12, 7, 2}, {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5} }, new Question0107Exercise().solve(new Integer[][] { {1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25} }));
    }

}
