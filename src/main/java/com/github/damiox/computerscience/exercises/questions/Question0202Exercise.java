package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;

/**
 * Return Kth to Last: Implement an algorithm to find the kth
 * to last element of a singly linked list.
 *
 * Solution:
 * 1) Iteratively
 * 1.a) have two main pointers: A & B
 *      Actually we also have C, which is only going half the way
 *      that C goes.
 * 1.b) move B 2k positions
 * 1.c) if B doesn't get null, then set A = B, and move on
 * 1.d) if B gets null, then if (n < k) it's an input error,
 * if not then move A (n-k) positions and return L[A]
 * 2) Recursively:
 * 2.a) If node.next is null, then return 0, because it'd be k=0
 * 2.b) Sum +1 to whatever was obtained from recursion
 * 2.c) in any case if returned K in recursion is equal to
 * the passed in k, then return final result
 *
 * Solution 1:
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Solution 2:
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author dnardelli
 */
public class Question0202Exercise<T> implements Exercise<Question0202Exercise.Params<T>, Question0202Exercise.Result<T>> {

    public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public static class Params<T> {
        public final Node<T> head;
        public final int k;

        public Params(Node<T> head, int k) {
            this.head = head;
            this.k = k;
        }
    }

    public static class Result<T> {
        public final T value1;
        public final T value2;

        public Result(T value1, T value2) {
            this.value1 = value1;
            this.value2 = value2;
        }
    }

    @Override
    public Result<T> solve(final Params<T> params) {
        T value1 = this.findKth1(params.head, params.k);
        T value2 = this.findKth2(params.head, params.k);

        return new Result(value1, value2);
    }

    private T findKth1(final Node<T> head, final int k) {
        if (head == null) {
            throw new IllegalArgumentException("head");
        }

        Node<T> currA = head;
        Node<T> currB = head;
        Node<T> currC = head;
        int n = 0;

        while (currB.next != null) {
            currA = currC;
            currB = currC;
            n = 0;
            for (; n < 2 * k + 1 && currB.next != null ; n++) {
                if (n < k + 1) {
                    currC = currC.next;
                }
                currB = currB.next;
            }
        }

        if (n < k) {
            throw new IllegalArgumentException("k is out of bounds");
        }

        for (int i = 0 ; i < n - k ; i++) {
            currA = currA.next;
        }

        return currA.data;
    }

    private T findKth2(final Node<T> head, final int k) {
        if (head == null) {
            throw new IllegalArgumentException("head");
        }

        return _findKth2(head, k).node.data;
    }

    private R<T> _findKth2(final Node<T> node, final int k) {
        if (node.next == null) {
            return new R(node, 0);
        }

        R r = _findKth2(node.next, k);
        if (r.k == k) {
            return r;
        }

        return new R(node, r.k + 1);
    }

    // only being used for recursion
    private static class R<T> {
        public final Node<T> node;
        public final int k;

        public R(Node<T> node, int k) {
            this.node = node;
            this.k = k;
        }
    }

}
