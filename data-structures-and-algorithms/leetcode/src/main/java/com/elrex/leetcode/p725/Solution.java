package com.elrex.leetcode.p725;

import com.elrex.leetcode.utils.IO;
import com.elrex.leetcode.utils.ListNode;

/**
 * Problem: 725. Split Linked List in Parts
 * @see <a href="https://leetcode.com/problems/split-linked-list-in-parts/description/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/11/17.
 */
public class Solution {

    /**
     * Time complexity: O(n + k) where n is the number of nodes, k is the number of parts
     * Space complexity: O(k) where k is the number of parts
     */
    public ListNode[] splitListToParts(ListNode root, int k) {
        // TC: O(1)
        // SC: O(k)
        ListNode[] result = new ListNode[k];
        // TC: O(n), where n is the number of nodes.
        // SC: O(1)
        int length = getLength(root);

        int partLen = length / k;
        int remain = length % k;
        ListNode C = root;
        ListNode P = root;

        // TC: O(k * l)
        for (int i = 0; i < k; i++, remain--) { // TC: O(k)
            result[i] = C;
            int len = partLen + (remain > 0 ? 1 : 0);
            for (int j = 0; j < len; j++) { // TC: O(l) where l is the length of each parts.
                P = C;
                C = C.next;
            }
            if (P != null) P.next = null;
        }
        return result;
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
        ListNode input = ListNode.arrayToLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        int k = 3;
        // Output: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
        IO.print(ListNode.linkedListsToArray(solution.splitListToParts(input, k)));

        input = ListNode.arrayToLinkedList(new int[] {1, 2, 3});
        k = 5;
        // Output: [[1], [2], [3], [], []]
        IO.print(ListNode.linkedListsToArray(solution.splitListToParts(input, k)));
    }
}
