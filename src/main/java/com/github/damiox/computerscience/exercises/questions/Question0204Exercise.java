package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;

import java.util.Comparator;

/**
 * Partition: Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than
 * or equal to x. lf x is contained within the list, the values of x
 * only need to be after the elements less than x (see below).
 * The partition element x can appear anywhere in the "right partition";
 * it does not need to appear between the left and right partitions.
 *
 * Solution: walk through L starting until curr.next != null
 * When curr.next.data is less than x, then move curr.next to the head
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class Question0204Exercise<T> implements Exercise<Question0204Exercise.Params<T>, Question0204Exercise.Node<T>> {

    public static class Params<T> {
        public final Node<T> head;
        public final T x;
        public final Comparator<T> comparator;

        Params(Node<T> head, T x, Comparator<T> comparator) {
            this.head = head;
            this.x = x;
            this.comparator = comparator;
        }
    }

    public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public Node<T> solve(final Params<T> params) {
        Node<T> head = params.head;
        final T x = params.x;
        final Comparator<T> comparator = params.comparator;

        if (head == null) {
            throw new IllegalArgumentException("head");
        }

        Node<T> curr = head;
        Node<T> newhead = head;

        while (curr.next != null) {
            if (comparator.compare(curr.next.data, x) < 0) {
                head = moveAhead(head, curr);
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    private Node<T> moveAhead(Node<T> head, Node<T> node) {
        // tmp node to avoid losing reference
        Node<T> tmp = node.next;
        // skip this node
        node.next = node.next.next;
        // our passed in node will be the new head
        tmp.next = head;
        return tmp;
    }

}
