package com.github.damiox.computerscience.exercises.data;

import com.github.damiox.computerscience.Exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Unweighted Graph implementation based on Adjacency list implementation.
 * Through this current implementation we can search on the graph by running DFS and BFS oriented searches.
 * This implementation does not address a weighted graph which should be handled
 * through Dijkstra or Bellman-Ford type algorithms.
 *
 * Note: Graph implemented through Adjacency Matrix
 *
 * @author dnardelli
 */
public class UnweightedMatrixGraphExercise implements Exercise<UnweightedMatrixGraphExercise.Graph, UnweightedMatrixGraphExercise.GraphSolver> {

    public static class Vertex {
        Vertex parent; // only to build the found path
        int data;
    }

    public static class Graph {
        final Vertex[] vertices;
        final int[][] edges;

        public Graph(Vertex[] vertices, int[][] edges) {
            this.vertices = vertices;
            this.edges = edges;
        }
    }

    @Override
    public GraphSolver solve(Graph graph) {
        return new GraphSolver(graph);
    }

    public static class GraphSolver {

        private final Graph graph;

        public GraphSolver(Graph graph) {
            this.graph = graph;
        }

        public SearchStats[] search(int data) {
            // representing an array of search stats with 2 positions
            // first position will have the search stats for the DFS-oriented search,
            // while the second position will have the search stats for the BFS-oriented search.
            final SearchStats[] searchStats = new SearchStats[2];

            // DFS Search
            searchStats[0] = searchDFS(data, graph, 0, new HashSet<>(), new SearchStats());

            // BFS Search
            searchStats[1] = searchBFS(data, graph, new HashSet<>(), new SearchStats());

            return searchStats;
        }

        public SearchStats searchDFS(int data, Graph graph, int i, Set<Vertex> visited, SearchStats searchStats) {
            final Vertex vertex = graph.vertices[i];

            visited.add(vertex);
            searchStats.numVisited++;

            if (vertex.data == data) {
                searchStats.found = true;
                searchStats.buildFoundPath(vertex);
                return searchStats;
            }

            for (int j = 0; j < graph.edges[i].length ; j++) {
                if (graph.edges[i][j] != 1) {
                    continue; // no edge between both vertex i and vertex j
                }

                final Vertex adjacent = graph.vertices[j];

                if (!visited.contains(adjacent)) {
                    adjacent.parent = vertex;
                    searchStats = searchDFS(data, graph, j, visited, searchStats);
                    if (searchStats.found) {
                        return searchStats;
                    }
                }
            }

            return searchStats;
        }

        public SearchStats searchBFS(int data, Graph graph, Set<Vertex> visited, SearchStats searchStats) {
            Queue<Integer> vertexToVisit = new LinkedList<>();
            vertexToVisit.add(0);

            while (!vertexToVisit.isEmpty()) {
                final Integer i = vertexToVisit.remove();
                final Vertex vertex = graph.vertices[i];

                visited.add(vertex);
                searchStats.numVisited++;

                if (vertex.data == data) {
                    searchStats.found = true;
                    searchStats.buildFoundPath(vertex);
                    return searchStats;
                }

                for (int j = 0; j < graph.edges[i].length ; j++) {
                    if (graph.edges[i][j] != 1) {
                        continue; // no edge between both vertex i and vertex j
                    }

                    final Vertex adjacent = graph.vertices[j];

                    if (!visited.contains(adjacent)) {
                        adjacent.parent = vertex; // setting parent to then recover the found path.
                        vertexToVisit.add(j);
                    }
                }
            }

            return searchStats;
        }

        public static class SearchStats {
            public boolean found;
            public Deque<Vertex> foundPath;
            public int numVisited;

            void buildFoundPath(Vertex vertex) {
                foundPath = new ArrayDeque<>();

                while (vertex != null) {
                    foundPath.push(vertex);
                    vertex = vertex.parent;
                }
            }
        }

    }

}
