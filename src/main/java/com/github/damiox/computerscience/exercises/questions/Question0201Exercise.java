package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove Dups: Write code to remove duplicates from an unsorted linked list.
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * Solution: we can use a HashMap to store the items as we are iterating through them
 * While walking through the items, we can look up the item is already in the HashMap
 * If so, then we will skip it by moving the corresponding pointers.
 * Another option to avoid using a temporary buffer would be to have two pointers
 * and basically to double iterate on the list.
 *
 * Note: implemented on a doubly linked list to add more complex
 *
 * Solution 1:
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Solution 2:
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class Question0201Exercise<T> implements Exercise<Question0201Exercise.Node<T>, Question0201Exercise.Result<T>> {

    public static class Node<T> {
        public T data;
        public Node<T> prev;
        public Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public boolean equals(Object obj) {
            if (Node.class.isInstance(obj)) {
                Node<T> other = Node.class.cast(obj);
                return this.data.equals(other.data);
            }

            return false;
        }

        @Override
        public int hashCode() {
            return this.data.hashCode();
        }

        void delete() {
            // fixing prev
            if (this.prev != null) {
                this.prev.next = this.next;
            }
            // fixing next
            if (this.next != null) {
                this.next.prev = this.prev;
            }
        }
    }

    public static class Result<T> {
        public final Node<T> deduped1;
        public final Node<T> deduped2;

        public Result(Node<T> deduped1, Node<T> deduped2) {
            this.deduped1 = deduped1;
            this.deduped2 = deduped2;
        }
    }

    @Override
    public Result<T> solve(final Node<T> head) {
        Node<T> deduped1 = this.dedup1(head);
        Node<T> deduped2 = this.dedup2(head);

        return new Result(deduped1, deduped2);
    }

    private Node<T> dedup1(final Node<T> head) {
        if (head == null) {
            throw new IllegalArgumentException("head");
        }

        Node<T> curr = head;
        Set<Node<T>> uniqueNodes = new HashSet<>();

        while (curr != null) {
            if (uniqueNodes.contains(curr)) {
                curr.delete();
            } else {
                uniqueNodes.add(curr);
            }
            curr = curr.next;
        }

        return head; // O(n) / O(n)
    }

    private Node<T> dedup2(final Node<T> head) {
        if (head == null) {
            throw new IllegalArgumentException("head");
        }

        Node<T> curr1 = head;

        while (curr1 != null) {
            Node<T> curr2 = curr1;
            while (curr2 != null && curr2.next != null) {
                if (curr1.equals(curr2.next)) {
                    curr2.next.delete();
                }
                curr2 = curr2.next;
            }
            curr1 = curr1.next;
        }

        return head; // O(n ^ 2) / O(1)
    }

}
