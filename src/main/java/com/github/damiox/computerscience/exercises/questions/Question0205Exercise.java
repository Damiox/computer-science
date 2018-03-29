package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;

/**
 * Sum Lists: You have two numbers represented by a linked list,
 * where each node contains a single digit. The digits are stored
 * in reverse order, such that the 1's digit is at the head of
 * the list. Write a function that adds the two numbers and
 * returns the sum as a linked list.
 *
 * FOLLOW UP
 * Suppose the digits are stored in forward order. Repeat the
 * above problem.
 *
 * Solution:
 * a) Have a carry temp variable to store the carry number
 * (so the otucome of the sum operation).
 * b) If A & B are stored in forward order, then: I need to start
 * reading the list from tail, but as I don't have a 'prev' pointer
 * then I need to create 2nd list with values in reverse order
 *
 * a)
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * b)
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author dnardelli
 */
public class Question0205Exercise implements Exercise<Question0205Exercise.Params, Question0205Exercise.Node> {

    public static class Params {
        public final Node A;
        public final Node B;
        public final boolean forwardOrder;

        Params(Node A, Node B, boolean forwardOrder) {
            this.A = A;
            this.B = B;
            this.forwardOrder = forwardOrder;
        }
    }

    public static class Node {
        public int digit;
        public Node next;

        public Node(int digit, Node next) {
            this.digit = digit;
            this.next = next;
        }
    }

    @Override
    public Node solve(final Params params) {
        final Node A = params.A;
        final Node B = params.B;
        final boolean forwardOrder = params.forwardOrder;

        if (A == null) {
            throw new IllegalArgumentException("A");
        }
        if (B == null) {
            throw new IllegalArgumentException("B");
        }

        return !forwardOrder ? this.solveA(A, B) : this.solveB(A, B);
    }

    private Node solveA(Node A, Node B) {
        int carry = 0;
        Node R = null;
        Node prev = null;

        while (A != null || B != null) {
            int r = carry;
            carry = 0;

            if (A != null) {
                r += A.digit;
                A = A.next;
            }
            if (B != null) {
                r += B.digit;
                B = B.next;
            }
            if (r > 9) {
                r %= 10;
                carry = 1;
            }

            Node curr = new Node(r, null);
            if (prev != null) {
                prev.next = curr;
            }
            prev = curr;
            if (R == null) {
                R = curr;
            }
        }

        return R;
    }

    private Node solveB(Node A, Node B) {
        return reverse(solveA(reverse(A), reverse(B)));
    }

    private Node reverse(Node N) {
        Node prev = null, curr = null;

        while (N != null) {
            curr = new Node(N.digit, null);
            if (prev != null) {
                curr.next = prev;
            }
            prev = curr;
            N = N.next;
        }

        return curr;
    }

}
