package com.elrex.leetcode.p445;

import com.elrex.leetcode.utils.IO;
import com.elrex.leetcode.utils.ListNode;

import java.util.Stack;

/**
 * Problem: 445. Add Two Numbers II
 * @see <a href="https://leetcode.com/problems/add-two-numbers-ii/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/11/11.
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        Stack<Integer> s1 = putListToStack(l1);
        Stack<Integer> s2 = putListToStack(l2);

        ListNode C = null;
        int sum = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();

            ListNode node = new ListNode(sum % 10);
            node.next = C;
            C = node;
            sum /= 10;
        }
        if (sum != 0) {
            ListNode node = new ListNode(sum);
            node.next = C;
            C = node;
        }
        return C;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        ListNode head = new ListNode(1);
        head.next = (len1 > len2) ? add(l1, l2, len1 - len2) : add (l2, l1, len2 - len1);
        if (head.next.val > 9) {
            head.next.val %= 10;
            return head;
        }
        return head.next;
    }

    public ListNode add(ListNode a, ListNode b, int diff) {
        if (a == null) return null;
        ListNode res = new ListNode((diff == 0) ? (a.val + b.val) : a.val);
        ListNode post = (diff == 0) ? add(a.next, b.next, 0) : add(a.next, b, diff - 1);
        if (post != null && post.val > 9) {
            post.val %= 10;
            res.val++;
        }
        res.next = post;
        return res;
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode C = head;
        while (C != null) {
            length++;
            C = C.next;
        }
        return length;
    }

    private Stack<Integer> putListToStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode C = head;
        while (C != null) {
            stack.add(C.val);
            C = C.next;
        }
        return stack;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode l1 = ListNode.arrayToLinkedList(new int[] {7, 2, 4, 3});
        ListNode l2 = ListNode.arrayToLinkedList(new int[] {5, 6, 4});
        // Output: [7, 8, 0, 7]
        IO.print(ListNode.linkedListToArray(solution.addTwoNumbers(l1, l2)));

        IO.print(ListNode.linkedListToArray(solution.addTwoNumbers2(l1, l2)));
    }
}
