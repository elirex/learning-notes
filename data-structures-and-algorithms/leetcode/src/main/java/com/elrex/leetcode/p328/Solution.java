package com.elrex.leetcode.p328;

import com.elrex.leetcode.utils.IO;
import com.elrex.leetcode.utils.ListNode;

/**
 * Problem: 328. Odd Even Linked List
 * @see <a href="https://leetcode.com/problems/odd-even-linked-list/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/11/18.
 */
public class Solution {

    /**
     * Time Complexity: O(n), where n is the number of nodes.
     * Space Complexity: O(1)
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode input = ListNode.arrayToLinkedList(new int[] {1, 2, 3, 4, 5});
        // Output: [1, 3, 5, 2, 4]
        IO.print(ListNode.linkedListToArray(solution.oddEvenList(input)));
    }
}
