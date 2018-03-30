package com.github.damiox.computerscience.exercises.questions;

import com.github.damiox.computerscience.Exercise;

/**
 * Loop Detection: Given a circular linked list, implement an
 * algorithm that returns the node at the beginning of the loop.
 *
 * Solution:
 * We could have a hashmap and to store all visited elements, and
 * check if they were visited before, when we found the first
 * occurrence, it means we found the loop, and we could find the
 * length of that and find where loop begins.
 * But we don't want to use O(n) space.
 * The ideal solution is to apply Floyd's cyclic detection
 * algorithm.
 * We need two pointers: S & F
 * S will go slower, and F will go faster, lets say twice faster
 * than S. Thus 2S = F
 * If we move both pointers, they will end up meeting at some
 * point, which means there's a loop. If F gets null at certain
 * point it means the given list is not a circular list, and
 * we should throw an exception.
 * Lets define m as the length from 0 to where the loop begins
 * Lets define k as the length from where the loops begin until
 * where S and F meet each other.
 * When S and F meet each other, that means they will have traveled
 * a certain distance, lets say:
 * S = m + p * l + k
 * F = m + q * l + k
 * Where p is the number of times S has gone through the loop to
 * meet F.
 * Where q is the number of times F has gone through the loop to
 * meet S.
 * And if we remember that 2S = F, then:
 * 2(m + p * l + k) = m + q * l + k
 * 2m + 2p * 2l + 2k = m + q * l + k
 * m + k = (q - 2p) * l
 * which means (m + k) is a multiple of the length of the loop,
 * that is l.
 * After S and F just met, if we move S to the beginning of the list
 * and we start moving S and F at the same speed, they will meet
 * at a certain point which means that will be where the loop begins.
 * That's what Floyd says, and it can be tested in math:
 * S will travel m times to get to where loop begins.
 * F will travel (m + k) times to get to where loop begins, and
 * m + k is multiple of the length of the loop, so it means they
 * will meet at the same point, which is the beginning of the loop.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author dnardelli
 */
public class Question0208Exercise<T> implements Exercise<Question0208Exercise.Node<T>, Question0208Exercise.Node<T>> {

    public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public Node<T> solve(final Question0208Exercise.Node<T> N) {
        if (N == null) {
            throw new IllegalArgumentException("N");
        }

        Node<T> S = N, F = N;

        while (F.next != null && S.next != F.next.next) {
            S = S.next;
            F = F.next.next;
        }

        if (F == null) {
            throw new IllegalStateException("N is not a circular list");
        }
        S = S.next;
        F = F.next.next;

        // After they met, S will start from the beginning and both pointers will move at same speed
        S = N;
        while (S != F) {
            S = S.next;
            F = F.next;
        }

        return S;
    }

}
