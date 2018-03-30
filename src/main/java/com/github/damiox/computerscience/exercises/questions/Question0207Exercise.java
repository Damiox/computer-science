package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;

/**
 * Intersection: Given two (singly) linked lists, determine if
 * the two lists intersect. Return the inter- secting node.
 * Note that the intersection is defined based on reference,
 * not value. That is, if the kth node of the first linked list
 * is the exact same node (by reference) as the jth node of the
 * second linked list, then they are intersecting.
 *
 * Solution:
 * 1) walk through A & B and get their corresponding sizes
 * 2) tails of A & B must be equal, that means they have a common
 * intersecting node.
 * 3) SA & SB are sizes of A & B respectively.
 * 3.a) if SA > SB, then move A pointer (SA - SB) times.
 * 3.b) if SA < SB, then move B pointer (SB - SA) times.
 * 4) Walk through both lists and check equality. When nodes are
 * equal, it means there's an intersecting node
 *
 * Time Complexity: O(A + B)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class Question0207Exercise<T> implements Exercise<Question0207Exercise.Params<T>, Question0207Exercise.Node<T>> {

    public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T letter, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static class Params<T> {
        public final Node<T> A;
        public final Node<T> B;

        Params(Node<T> A, Node<T> B) {
            this.A = A;
            this.B = B;
        }
    }

    @Override
    public Node<T> solve(final Question0207Exercise.Params params) {
        final Node<T> A = params.A;
        final Node<T> B = params.B;

        if (A == null) {
            throw new IllegalArgumentException("A");
        }
        if (B == null) {
            throw new IllegalArgumentException("B");
        }

        Node<T> currA = A, currB = B;
        int SA = 1, SB = 1;

        // Step 1
        while (currA.next != null) {
            SA++;
            currA = currA.next;
        }
        while (currB.next != null) {
            SB++;
            currB = currB.next;
        }

        // Step 2
        if (currA != currB) {
            // tails different, then no intersection node
            return null;
        }

        // Step 3
        currA = SA > SB ? forwardOnList(A, SA - SB) : A;
        currB = SA < SB ? forwardOnList(B, SB - SA) : B;

        // Step 4
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }

        return currA;
    }

    private Node<T> forwardOnList(Node<T> N, int times) {
        for (int i = 0 ; i < times ; i++) {
            N = N.next;
        }

        return N;
    }

}
