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
// @                                   @       @   @
// @   @ @ @ @ @ @ @ @ @ @ @ @ @   @   @   @ @ @   @
// @               @       @       @       @       @
// @ @ @   @ @ @ @ @   @   @ @ @ @ @   @ @ @   @   @
// @   @   @           @           @       @   @   @
// @   @   @   @ @ @ @ @ @ @ @ @   @   @ @ @   @   @
// @   @   @   @               @   @   @       @   @
// @   @ @ @   @   @ @ @   @ @ @   @   @   @ @ @   @
// @       @   @   @       @       @   @       @   @
// @ @ @   @   @   @   @ @ @   @ @ @ @ @   @ @ @   @
// @           @   @                       @ @ @   @
// @ @ @ @ @ @ @ @ @ @ @ @ @   @ @ @ @ @ @ @ @ @ @ @    <- exit (node 55)
//
public class UnweightedMatrixGraphExerciseTest {

    @Test
    public void testSolve() {
        final UnweightedMatrixGraphExercise.Graph graph = Utils.buildMaze();
        final UnweightedMatrixGraphExercise.GraphSolver graphSolver = new UnweightedMatrixGraphExercise().solve(graph);

        UnweightedMatrixGraphExercise.GraphSolver.SearchStats[] searchStats = graphSolver.search(55 /* quit */);

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

        private static UnweightedMatrixGraphExercise.Graph buildMaze() {
            // Building the Graph from the Entrance (which is '2' data) to the Exit (which is '3' data)
            // passing through the different paths represented with '1' data
            //
            // 0 0 0 0 0 0 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0
            // 0 1 1 1 1 1 1 1 1 1 0 1 1 1 1 1 1 1 0 1 1 1 1 1 0
            // 0 1 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 1 0
            // 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 0
            // 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 1 0 0 0 1 0
            // 0 1 1 1 1 1 1 1 0 1 1 1 0 1 1 1 0 1 1 1 0 1 1 1 0
            // 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 0 0 1 0 0 0 1 0 1 0
            // 0 1 0 1 0 1 1 1 1 1 0 1 1 1 1 1 0 1 1 1 0 1 0 1 0
            // 0 1 0 1 0 1 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 1 0 1 0
            // 0 1 0 1 0 1 0 1 1 1 1 1 1 1 0 1 0 1 0 1 1 1 0 1 0
            // 0 1 0 0 0 1 0 1 0 0 0 1 0 0 0 1 0 1 0 1 0 0 0 1 0
            // 0 1 1 1 0 1 0 1 0 1 1 1 0 1 1 1 0 1 0 1 1 1 0 1 0
            // 0 0 0 1 0 1 0 1 0 1 0 0 0 1 0 0 0 0 0 1 0 0 0 1 0
            // 0 1 1 1 1 1 0 1 0 1 1 1 1 1 1 1 1 1 1 1 0 0 0 1 0
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
            // Now we can turn that graph nodes into our adjacency matrix as shown below:
            //

            UnweightedMatrixGraphExercise.Vertex[] vertices = new UnweightedMatrixGraphExercise.Vertex[56 /* total nodes */];
            for (int i = 0 ; i < vertices.length ; i++) {
                vertices[i] = new UnweightedMatrixGraphExercise.Vertex();
                vertices[i].data = i;
            }

            int[][] edges = new int[56][56];

            // n01
            edges[0][4] = 1;
            // n02
            edges[1][2] = 1;
            edges[1][8] = 1;
            // n03
            edges[2][1] = 1;
            // n04
            edges[3][4] = 1;
            edges[3][9] = 1;
            // n05
            edges[4][3] = 1;
            edges[4][0] = 1;
            edges[4][5] = 1;
            // n06
            edges[5][4] = 1;
            edges[5][11] = 1;
            // n07
            edges[6][7] = 1;
            edges[6][12] = 1;
            // n08
            edges[7][6] = 1;
            edges[7][13] = 1;
            // n09
            edges[8][1] = 1;
            edges[8][9] = 1;
            edges[8][14] = 1;
            // n10
            edges[9][8] = 1;
            edges[9][3] = 1;
            edges[9][10] = 1;
            // n11
            edges[10][9] = 1;
            edges[10][11] = 1;
            edges[10][20] = 1;
            // n12
            edges[11][10] = 1;
            edges[11][5] = 1;
            edges[11][12] = 1;
            edges[11][21] = 1;
            // n13
            edges[12][11] = 1;
            edges[12][6] = 1;
            edges[12][13] = 1;
            edges[12][22] = 1;
            // n14
            edges[13][12] = 1;
            edges[13][7] = 1;
            edges[13][24] = 1;
            // n15
            edges[14][8] = 1;
            edges[14][15] = 1;
            // n16
            edges[15][14] = 1;
            edges[15][16] = 1;
            edges[15][32] = 1;
            // n17
            edges[16][15] = 1;
            // n18
            edges[17][18] = 1;
            edges[17][27] = 1;
            // n19
            edges[18][17] = 1;
            edges[18][28] = 1;
            // n20
            edges[19][20] = 1;
            // n21
            edges[20][19] = 1;
            edges[20][10] = 1;
            // n22
            edges[21][11] = 1;
            edges[21][22] = 1;
            edges[21][30] = 1;
            // n23
            edges[22][21] = 1;
            edges[22][12] = 1;
            // n24
            edges[23][24] = 1;
            edges[23][37] = 1;
            // n25
            edges[24][23] = 1;
            edges[24][54] = 1;
            // n26
            edges[25][38] = 1;
            // n27
            edges[26][27] = 1;
            edges[26][48] = 1;
            // n28
            edges[27][26] = 1;
            edges[27][17] = 1;
            // n29
            edges[28][29] = 1;
            edges[28][18] = 1;
            // n30
            edges[29][28] = 1;
            edges[29][43] = 1;
            // n31
            edges[30][21] = 1;
            edges[30][31] = 1;
            edges[30][44] = 1;
            // n32
            edges[31][30] = 1;
            // n33
            edges[32][15] = 1;
            // n34
            edges[33][34] = 1;
            edges[33][50] = 1;
            // n35
            edges[34][33] = 1;
            edges[34][35] = 1;
            edges[34][41] = 1;
            // n36
            edges[35][34] = 1;
            // n37
            edges[36][37] = 1;
            edges[36][45] = 1;
            // n38
            edges[37][36] = 1;
            edges[37][23] = 1;
            // n39
            edges[38][25] = 1;
            edges[38][39] = 1;
            // n40
            edges[39][38] = 1;
            edges[39][48] = 1;
            // n41
            edges[40][41] = 1;
            edges[40][51] = 1;
            // n42
            edges[41][40] = 1;
            edges[41][34] = 1;
            // n43
            edges[42][43] = 1;
            edges[42][52] = 1;
            // n44
            edges[43][42] = 1;
            edges[43][29] = 1;
            // n45
            edges[44][30] = 1;
            // n46
            edges[45][36] = 1;
            edges[45][46] = 1;
            edges[45][53] = 1;
            // n47
            edges[46][45] = 1;
            // n48
            edges[47][48] = 1;
            // n49
            edges[48][47] = 1;
            edges[48][39] = 1;
            edges[48][49] = 1;
            // n50
            edges[49][48] = 1;
            edges[49][26] = 1;
            // n51
            edges[50][33] = 1;
            // n52
            edges[51][40] = 1;
            edges[51][52] = 1;
            // n53
            edges[52][51] = 1;
            edges[52][42] = 1;
            edges[52][53] = 1;
            edges[52][55] = 1;
            // n54
            edges[53][52] = 1;
            edges[53][45] = 1;
            // n55
            edges[54][24] = 1;
            // n56
            edges[55][52] = 1;

            return new UnweightedMatrixGraphExercise.Graph(vertices, edges);
        }

    }

}
