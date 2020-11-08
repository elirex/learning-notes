package com.elrex.leetcode.p19;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 19. Remove Nth Node From End of List
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/11/8.
 */
public class Solution {

    public ListNode removeNthFroEnd(ListNode head, int n) {
        if (head == null) return head;
        int length = getLength(head);
        if (n == length) return head.next;

        length -= n;
        ListNode current = head;
        while (--length > 0) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

    public ListNode removeNthFroEnd2(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        ListNode slow = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }


    private int getLength(ListNode head) {
        ListNode c = head;
        int length = 0;
        while (c != null) {
            length++;
            c = c.next;
        }
        return length;
    }

    public static void main(String[] args) {
       Solution solution = new Solution();
       ListNode head = generateLinkedList(new int[]{1, 2, 3, 4, 5});
       int n = 2;
       // Output: [1, 2, 3, 5]
       System.out.println(linkedListToArray(solution.removeNthFroEnd(head, n)));

       head = generateLinkedList(new int[]{1});
       n = 1;
       // Output: []
       System.out.println(linkedListToArray(solution.removeNthFroEnd(head, n)));

        head = generateLinkedList(new int[]{1, 2});
        n = 1;
        // Output: [1]
        System.out.println(linkedListToArray(solution.removeNthFroEnd(head, n)));

        head = generateLinkedList(new int[]{1, 2, 3, 4, 5});
        n = 2;
        // Output: [1, 2, 3, 5]
        System.out.println(linkedListToArray(solution.removeNthFroEnd2(head, n)));

        head = generateLinkedList(new int[]{1});
        n = 1;
        // Output: []
        System.out.println(linkedListToArray(solution.removeNthFroEnd2(head, n)));

        head = generateLinkedList(new int[]{1, 2});
        n = 1;
        // Output: [1]
        System.out.println(linkedListToArray(solution.removeNthFroEnd2(head, n)));
    }

    static List<Integer> linkedListToArray(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        return list;
    }

    static ListNode generateLinkedList(int[] arr) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int n : arr) {
            current.next = new ListNode(n);
            current = current.next;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) {
            this(val ,null);
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
