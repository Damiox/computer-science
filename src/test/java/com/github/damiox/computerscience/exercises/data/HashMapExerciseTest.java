package com.github.damiox.computerscience.exercises.data;

import org.junit.Assert;
import org.junit.Test;

public class HashMapExerciseTest {

    @Test
    public void testSolve() {
        HashMapExercise.HashMap hashMap = new HashMapExercise.HashMap();

        hashMap.add("n1", "d1");
        hashMap.add("n2", "d2");
        hashMap.add("n3", "d3");
        hashMap.add("n4", "d4");

        // testing get...
        Assert.assertEquals("d1", hashMap.get("n1"));
        Assert.assertEquals("d2", hashMap.get("n2"));
        Assert.assertEquals("d3", hashMap.get("n3"));
        Assert.assertEquals("d4", hashMap.get("n4"));
        Assert.assertNull(hashMap.get("n5"));

        // testing size...
        Assert.assertEquals(4, hashMap.size());

        // testing containsKey...
        Assert.assertTrue(hashMap.containsKey("n1"));
        Assert.assertTrue(hashMap.containsKey("n2"));
        Assert.assertTrue(hashMap.containsKey("n3"));
        Assert.assertTrue(hashMap.containsKey("n4"));
        Assert.assertFalse(hashMap.containsKey("x"));
        Assert.assertFalse(hashMap.containsKey("y"));
        Assert.assertFalse(hashMap.containsKey("z"));

        // testing remove...
        Assert.assertFalse(hashMap.remove("n0"));
        Assert.assertTrue(hashMap.remove("n1"));
        Assert.assertFalse(hashMap.remove("n1"));
        Assert.assertTrue(hashMap.remove("n2"));

        // testing some stuff again...
        Assert.assertEquals(2, hashMap.size());
        Assert.assertNull(hashMap.get("n1"));
        Assert.assertNull(hashMap.get("n1"));
        Assert.assertFalse(hashMap.containsKey("n1"));
        Assert.assertFalse(hashMap.containsKey("n2"));
        Assert.assertTrue(hashMap.containsKey("n3"));
        Assert.assertEquals("d3", hashMap.get("n3"));
    }

}
