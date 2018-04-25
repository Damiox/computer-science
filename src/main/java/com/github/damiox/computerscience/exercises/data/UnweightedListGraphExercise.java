package com.github.damiox.computerscience.exercises.data;

import com.github.damiox.computerscience.Exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Unweighted Graph implementation based on Adjacency list implementation.
 * Through this current implementation we can search on the graph by running DFS and BFS oriented searches.
 * This implementation does not address a weighted graph which should be handled
 * through Dijkstra or Bellman-Ford type algorithms.
 *
 * Note: Graph implemented through Adjacency List
 *
 * @author dnardelli
 */
public class UnweightedListGraphExercise implements Exercise<UnweightedListGraphExercise.Graph, UnweightedListGraphExercise.GraphSolver> {

    public static class Vertex {
        Vertex parent; // only to build the found path
        Vertex[] adjacents;
        int data;
    }

    public static class Graph {
        final Vertex root;

        public Graph(Vertex root) {
            this.root = root;
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
            searchStats[0] = searchDFS(data, graph.root, new HashSet<>(), new SearchStats());

            // BFS Search
            searchStats[1] = searchBFS(data, graph.root, new HashSet<>(), new SearchStats());

            return searchStats;
        }

        public SearchStats searchDFS(int data, Vertex vertex, Set<Vertex> visited, SearchStats searchStats) {
            visited.add(vertex);
            searchStats.numVisited++;

            if (vertex.data == data) {
                searchStats.found = true;
                searchStats.buildFoundPath(vertex);
                return searchStats;
            }

            for (Vertex adjacent : vertex.adjacents) {
                if (!visited.contains(adjacent)) {
                    adjacent.parent = vertex;
                    searchStats = searchDFS(data, adjacent, visited, searchStats);
                    if (searchStats.found) {
                        return searchStats;
                    }
                }
            }

            return searchStats;
        }

        public SearchStats searchBFS(int data, Vertex vertex, Set<Vertex> visited, SearchStats searchStats) {
            Queue<Vertex> vertexToVisit = new LinkedList<>();
            vertexToVisit.add(vertex);

            while (!vertexToVisit.isEmpty()) {
                vertex = vertexToVisit.remove();

                visited.add(vertex);
                searchStats.numVisited++;

                if (vertex.data == data) {
                    searchStats.found = true;
                    searchStats.buildFoundPath(vertex);
                    return searchStats;
                }

                for (Vertex adjacent : vertex.adjacents) {
                    if (!visited.contains(adjacent)) {
                        adjacent.parent = vertex; // setting parent to then recover the found path.
                        vertexToVisit.add(adjacent);
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
