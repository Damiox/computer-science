package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;

/**
 * Delete Middle Node: Implement an algorithm to delete a node
 * in the middle (i.e., any node but the first and last node,
 * not necessarily the exact middle) of a singly linked list,
 * given only access to that node.
 *
 * Solution: walk through L making sure it's not the last node.
 * When the element is found, then skip it:
 * curr.next = curr.next.next;
 * Check always that curr.next != null && curr.next.next != null
 * so we never delete last nodes.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class Question0203Exercise<T> implements Exercise<Question0203Exercise.Params<T>, Boolean> {

    public static class Params<T> {
        public final Node<T> head;
        public final T value;

        Params(Node<T> head, T value) {
            this.head = head;
            this.value = value;
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
    public Boolean solve(final Params<T> params) {
        final Node<T> head = params.head;
        final T value = params.value;

        if (head == null) {
            throw new IllegalArgumentException("head");
        }

        Node<T> curr = head;

        while (curr.next != null && curr.next.next != null) {
            if (curr.next.data.equals(value)) {
                curr.next = curr.next.next;
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

}
