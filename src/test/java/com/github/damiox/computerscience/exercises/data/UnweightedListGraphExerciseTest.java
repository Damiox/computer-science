package com.github.damiox.computerscience.exercises.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

// Building Example
//
// @ @ @ @ @ @ @ @ @ @ @ @ @   @ @ @ @ @ @ @ @ @ @ @   <- entrance
// @                   @               @           @
// @   @ @ @ @ @ @ @ @ @   @ @ @ @ @   @   @ @ @   @
// @                               @   @       @   @
// @   @ @ @ @ @ @ @ @ @ @ @ @ @   @   @   @ @ @   @
// @               @       @       @       @       @
// @ @ @   @ @ @ @ @   @   @ @ @ @ @   @ @ @   @   @
// @   @   @           @           @       @   @   @
// @   @   @   @ @ @ @ @ @ @ @ @   @   @ @ @   @   @
// @   @   @   @               @   @   @       @   @
// @   @ @ @   @   @ @ @   @ @ @   @   @   @ @ @   @
// @       @   @   @       @       @   @       @   @
// @ @ @   @   @   @   @ @ @   @ @ @ @ @ @ @   @   @
// @           @   @                           @   @
// @ @ @ @ @ @ @ @ @ @ @ @ @   @ @ @ @ @ @ @ @ @ @ @    <- exit (node 55)
//
public class UnweightedListGraphExerciseTest {

    @Test
    public void testSolve() {
        final UnweightedListGraphExercise.Graph graph = Utils.buildMaze();
        final UnweightedListGraphExercise.GraphSolver graphSolver = new UnweightedListGraphExercise().solve(graph);

        UnweightedListGraphExercise.GraphSolver.SearchStats[] searchStats = graphSolver.search(55 /* quit */);

        // DFS path found: (shown through asterisks)
        //
        //   Graph:                                           Vertices:
        //                           *                        <-- entrance (node 01)
        //   1---------------1   *****-------1   *********
        //   |                   *           |   *       *
        //   1-------------------*****************-------*
        //   |                           |   |   |       *
        //   1---1-------1   1---1   1---1   1---1   *****
        //       |           |   |           |       *   |
        //   1   |   1-------1   1-------1   1---1   *   |
        //   |   |   |                   |   |       *   |
        //   |   1   |   1-------1---1   |   |   *****   |
        //   |       |   |       |       |   |   *       |
        //   1---1   |   |   1---1   1---1   1   *---1   |
        //       |   |   |   |       |           *       |
        //   1---1---1   1   1-------*************       1
        //                           *                        <-- exit (node 55)
        //
        Assert.assertTrue(searchStats[0].found);
        Assert.assertEquals(48, searchStats[0].numVisited);
        Assert.assertEquals(Arrays.asList(0, 4, 3, 9, 10, 11, 12, 6, 7, 13, 24, 23, 37, 36, 45, 53, 52, 55), searchStats[0].foundPath.stream().map(v -> v.data).collect(Collectors.toList()));

        // BFS path found: (shown through asterisks)
        //
        //   Graph:                                           Vertices:
        //                           *                        <-- entrance (node 01)
        //   1---------------1   1---*********   1-------1
        //   |                   |           *   |       |
        //   1-------------------1-------1---*************
        //   |                           |   |   |       *
        //   1---1-------1   1---1   1---1   1---1   *****
        //       |           |   |           |       *   |
        //   1   |   1-------1   1-------1   1---1   *   |
        //   |   |   |                   |   |       *   |
        //   |   1   |   1-------1---1   |   |   *****   |
        //   |       |   |       |       |   |   *       |
        //   1---1   |   |   1---1   1---1   1   *---1   |
        //       |   |   |   |       |           *       |
        //   1---1---1   1   1-------*************       1
        //                           *                        <-- exit (node 55)
        //
        Assert.assertTrue(searchStats[1].found);
        Assert.assertEquals(42, searchStats[1].numVisited);
        Assert.assertEquals(Arrays.asList(0, 4, 5, 11, 12, 13, 24, 23, 37, 36, 45, 53, 52, 55), searchStats[1].foundPath.stream().map(v -> v.data).collect(Collectors.toList()));

    }

    private static class Utils {

        private static UnweightedListGraphExercise.Graph buildMaze() {
            // Building the Graph from the Entrance (which is '2' data) to the Exit (which is '3' data)
            // passing through the different paths represented with '1' data
            //
            // 0 0 0 0 0 0 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0
            // 0 1 1 1 1 1 1 1 1 1 0 1 1 1 1 1 1 1 0 1 1 1 1 1 0
            // 0 1 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 1 0
            // 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 0 1 1 1 0 1 0
            // 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 1 0 0 0 1 0
            // 0 1 1 1 1 1 1 1 0 1 1 1 0 1 1 1 0 1 1 1 0 1 1 1 0
            // 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 0 0 1 0 0 0 1 0 1 0
            // 0 1 0 1 0 1 1 1 1 1 0 1 1 1 1 1 0 1 1 1 0 1 0 1 0
            // 0 1 0 1 0 1 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 1 0 1 0
            // 0 1 0 1 0 1 0 1 1 1 1 1 1 1 0 1 0 1 0 1 1 1 0 1 0
            // 0 1 0 0 0 1 0 1 0 0 0 1 0 0 0 1 0 1 0 1 0 0 0 1 0
            // 0 1 1 1 0 1 0 1 0 1 1 1 0 1 1 1 0 1 0 1 1 1 0 1 0
            // 0 0 0 1 0 1 0 1 0 1 0 0 0 1 0 0 0 0 0 0 0 1 0 1 0
            // 0 1 1 1 1 1 0 1 0 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 0
            // 0 0 0 0 0 0 0 0 0 0 0 0 0 3 0 0 0 0 0 0 0 0 0 0 0
            //
            // Drawing the Graph nodes we get the following:
            //
            //
            //   Graph:                                           Vertices:
            //                           2                        (n01)
            //   1---------------1   1---1-------1   1-------1    (n02, n03, n04, n05, n06, n07, n08)
            //   |                   |           |   |       |
            //   1-------------------1-------1---1---1-------1    (n09, n10, n11, n12, n13, n14)
            //   |                           |   |   |       |
            //   1---1-------1   1---1   1---1   1---1   1---1    (n15, n16, n17, n18, n19, n20, n21, n22, n23, n24, n25)
            //       |           |   |           |       |   |
            //   1   |   1-------1   1-------1   1---1   |   |    (n26, n27, n28, n29, n30, n31, n32)
            //   |   |   |                   |   |       |   |
            //   |   1   |   1-------1---1   |   |   1---1   |    (n33, n34, n35, n36, n37, n38)
            //   |       |   |       |       |   |   |       |
            //   1---1   |   |   1---1   1---1   1   1---1   |    (n39, n40, n41, n42, n43, n44, n45, n46, n47)
            //       |   |   |   |       |           |       |
            //   1---1---1   1   1-------1-----------1       1    (n48, n49, n50, n51, n52, n53, n54, n55)
            //                           3                        (n56)
            //
            // Now we can turn that graph nodes into our adjacency list as shown below:
            //

            UnweightedListGraphExercise.Vertex[] vertices = new UnweightedListGraphExercise.Vertex[56 /* total nodes */];
            for (int i = 0 ; i < vertices.length ; i++) {
                vertices[i] = new UnweightedListGraphExercise.Vertex();
                vertices[i].data = i;
            }

            // n01
            vertices[0].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[4] };
            // n02
            vertices[1].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[2], vertices[8] };
            // n03
            vertices[2].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[1] };
            // n04
            vertices[3].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[4], vertices[9] };
            // n05
            vertices[4].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[3], vertices[0], vertices[5] };
            // n06
            vertices[5].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[4], vertices[11] };
            // n07
            vertices[6].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[7], vertices[12] };
            // n08
            vertices[7].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[6], vertices[13] };
            // n09
            vertices[8].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[1], vertices[9], vertices[14] };
            // n10
            vertices[9].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[8], vertices[3], vertices[10] };
            // n11
            vertices[10].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[9], vertices[11], vertices[20] };
            // n12
            vertices[11].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[10], vertices[5], vertices[12], vertices[21] };
            // n13
            vertices[12].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[11], vertices[6], vertices[13], vertices[22] };
            // n14
            vertices[13].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[12], vertices[7], vertices[24] };
            // n15
            vertices[14].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[8], vertices[15] };
            // n16
            vertices[15].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[14], vertices[16], vertices[32] };
            // n17
            vertices[16].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[15] };
            // n18
            vertices[17].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[18], vertices[27] };
            // n19
            vertices[18].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[17], vertices[28] };
            // n20
            vertices[19].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[20] };
            // n21
            vertices[20].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[19], vertices[10] };
            // n22
            vertices[21].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[11], vertices[22], vertices[30] };
            // n23
            vertices[22].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[21], vertices[12] };
            // n24
            vertices[23].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[24], vertices[37] };
            // n25
            vertices[24].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[23], vertices[54] };
            // n26
            vertices[25].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[38] };
            // n27
            vertices[26].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[27], vertices[48] };
            // n28
            vertices[27].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[26], vertices[17] };
            // n29
            vertices[28].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[29], vertices[18] };
            // n30
            vertices[29].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[28], vertices[43] };
            // n31
            vertices[30].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[21], vertices[31], vertices[44] };
            // n32
            vertices[31].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[30] };
            // n33
            vertices[32].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[15] };
            // n34
            vertices[33].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[34], vertices[50] };
            // n35
            vertices[34].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[33], vertices[35], vertices[41] };
            // n36
            vertices[35].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[34] };
            // n37
            vertices[36].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[37], vertices[45] };
            // n38
            vertices[37].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[36], vertices[23] };
            // n39
            vertices[38].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[25], vertices[39] };
            // n40
            vertices[39].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[38], vertices[48] };
            // n41
            vertices[40].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[41], vertices[51] };
            // n42
            vertices[41].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[40], vertices[34] };
            // n43
            vertices[42].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[43], vertices[52] };
            // n44
            vertices[43].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[42], vertices[29] };
            // n45
            vertices[44].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[30] };
            // n46
            vertices[45].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[36], vertices[46], vertices[53] };
            // n47
            vertices[46].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[45] };
            // n48
            vertices[47].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[48] };
            // n49
            vertices[48].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[47], vertices[39], vertices[49] };
            // n50
            vertices[49].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[48], vertices[26] };
            // n51
            vertices[50].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[33] };
            // n52
            vertices[51].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[40], vertices[52] };
            // n53
            vertices[52].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[51], vertices[42], vertices[53], vertices[55] };
            // n54
            vertices[53].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[52], vertices[45] };
            // n55
            vertices[54].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[24] };
            // n56
            vertices[55].adjacents = new UnweightedListGraphExercise.Vertex[] { vertices[52] };

            return new UnweightedListGraphExercise.Graph(vertices[0]);
        }

    }

}
