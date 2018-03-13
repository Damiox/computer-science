package com.github.damiox.computerscience.exercises.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class ArrayListExerciseTest {

    @Test
    public void testSolve() {
        final Integer[] FIXED = new Integer[200];
        for (int i = 0 ; i < 200 ; i++) {
            FIXED[i] = i;
        }

        ArrayListExercise.ArrayList arrayList = new ArrayListExercise().solve(FIXED);

        Assert.assertEquals(200, arrayList.size());
        Assert.assertEquals(320, arrayList.getCapacity());
        Assert.assertEquals(-100, arrayList.get(50));
        Assert.assertEquals(0, arrayList.get(0));
        Assert.assertTrue(arrayList.contains(199));
        Assert.assertFalse(arrayList.contains(200));
        arrayList.remove(199);
        Assert.assertFalse(arrayList.contains(199));
        Assert.assertEquals(199, arrayList.size());

        int j = 0;
        for (int i : arrayList) {
            if (j != 50) {
                Assert.assertEquals(j++, i);
            }
        }

        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            int i = it.next();
            if (j != 50) {
                Assert.assertEquals(j++, i);
            }
        }
    }

}
