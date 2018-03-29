package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;

/**
 * Palindrome: Implement a function to check if a linked
 * list is a palindrome.
 *
 * Solution:
 * 1) Get the reverse list of the passed in list
 * 2) Walk through both lists and check equality
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author dnardelli
 */
public class Question0206Exercise implements Exercise<Question0206Exercise.Node, Boolean> {

    public static class Node {
        public char letter;
        public Node next;

        public Node(char letter, Node next) {
            this.letter = letter;
            this.next = next;
        }
    }

    @Override
    public Boolean solve(final Question0206Exercise.Node N) {
        if (N == null) {
            throw new IllegalArgumentException("N");
        }

        ReverseResult R = reverse(N);
        Node L = N;
        Node Lr = R.reversed;

        for (int i = 0 ; i < R.size / 2 ; i++) {
            if (L.letter != Lr.letter) {
                return false;
            }

            L = L.next;
            Lr = Lr.next;
        }

        return true;
    }

    private ReverseResult reverse(Node N) {
        Node prev = null, curr = null;
        int n = 0;

        while (N != null) {
            curr = new Node(N.letter, null);
            if (prev != null) {
                curr.next = prev;
            }
            prev = curr;
            N = N.next;
            n++;
        }

        return new ReverseResult(curr, n);
    }

    private static class ReverseResult {
        final Node reversed;
        final int size;

        ReverseResult(Node reversed, int size) {
            this.reversed = reversed;
            this.size = size;
        }
    }

}
