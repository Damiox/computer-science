package com.github.damiox.computerscience.exercises.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PermuteStringExerciseTest {

    @Test
    public void testSolve() {
        List<String> permutes;

        permutes = new PermuteStringExercise().solve("abc"); // 3! = 6
        Assert.assertEquals(6, permutes.size());
        Assert.assertTrue(permutes.contains("abc"));
        Assert.assertTrue(permutes.contains("cab"));
        Assert.assertTrue(permutes.contains("bca"));
        Assert.assertTrue(permutes.contains("acb"));
        Assert.assertTrue(permutes.contains("bac"));
        Assert.assertTrue(permutes.contains("cba"));

        permutes = new PermuteStringExercise().solve("dami"); // 4! = 24
        Assert.assertEquals(24, permutes.size());
        Assert.assertTrue(permutes.contains("dami"));
        Assert.assertTrue(permutes.contains("daim"));
        Assert.assertTrue(permutes.contains("dmai"));
        Assert.assertTrue(permutes.contains("dmia"));
        Assert.assertTrue(permutes.contains("dima"));
        Assert.assertTrue(permutes.contains("diam"));
        Assert.assertTrue(permutes.contains("imad"));
        Assert.assertTrue(permutes.contains("idam"));
        Assert.assertTrue(permutes.contains("idma"));
        Assert.assertTrue(permutes.contains("iadm"));
        Assert.assertTrue(permutes.contains("iamd"));
        Assert.assertTrue(permutes.contains("imda"));
        Assert.assertTrue(permutes.contains("madi"));
        Assert.assertTrue(permutes.contains("maid"));
        Assert.assertTrue(permutes.contains("mdai"));
        Assert.assertTrue(permutes.contains("mdia"));
        Assert.assertTrue(permutes.contains("miad"));
        Assert.assertTrue(permutes.contains("mida"));
        Assert.assertTrue(permutes.contains("admi"));
        Assert.assertTrue(permutes.contains("adim"));
        Assert.assertTrue(permutes.contains("amdi"));
        Assert.assertTrue(permutes.contains("amid"));
        Assert.assertTrue(permutes.contains("aidm"));
        Assert.assertTrue(permutes.contains("aimd"));
    }

}
