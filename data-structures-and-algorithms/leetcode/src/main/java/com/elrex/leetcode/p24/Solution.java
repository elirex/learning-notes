package com.elrex.leetcode.p24;

import com.elrex.leetcode.utils.IO;
import com.elrex.leetcode.utils.ListNode;

/**
 * Problem: 24. Swap Nodes in Pairs
 * @see <a href="https://leetcode.com/problems/swap-nodes-in-pairs/description/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/11/10.
 */
class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        ListNode C = dummy;
        while (C != null && C.next != null && C.next.next != null) {
            ListNode N1 = C.next;
            ListNode N2 = N1.next;

            N1.next = N2.next;
            N2.next = N1;

            C.next = N2;
            C = N1;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode input = ListNode.arrayToLinkedList(new int[] {1, 2, 3, 4});
        // Output: [2, 1, 4, 3]
        IO.print(ListNode.linkedListToArray(solution.swapPairs(input)));

        input = ListNode.arrayToLinkedList(new int[] {});
        // Output: []
        IO.print(ListNode.linkedListToArray(solution.swapPairs(input)));

        input = ListNode.arrayToLinkedList(new int[] {1});
        // Output: [1]
        IO.print(ListNode.linkedListToArray(solution.swapPairs(input)));
    }

}
