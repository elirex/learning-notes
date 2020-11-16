package com.elrex.leetcode.p234;

import com.elrex.leetcode.utils.IO;
import com.elrex.leetcode.utils.ListNode;

/**
 * Problem: 234. Palindrome Linked List
 * @see <a herf="https://leetcode.com/problems/palindrome-linked-list/description/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/11/16.
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) slow = slow.next;
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode P = null;
        ListNode C = head;
        ListNode N = null;
        while (C != null) {
            N = C.next;
            C.next = P;
            P = C;
            C = N;
        }
        return P;
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode input = ListNode.arrayToLinkedList(new int[] {1, 2, 2, 1});
        // Output: true
        IO.print(solution.isPalindrome(input));
    }
}
