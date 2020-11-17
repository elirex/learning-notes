package com.elrex.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/11/10.
 */
public class ListNode {

    public static ListNode arrayToLinkedList(int[] arr) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int n : arr) {
            current.next = new ListNode(n);
            current = current.next;
        }
        return dummy.next;
    }

    public static int[] linkedListToArray(ListNode head) {
        int length = getLength(head);
        if (length == 0) return new int[] {};
        int[] array = new int[length];
        ListNode c = head;
        for (int i = 0; i < length && c != null; i++) {
            array[i] = c.val;
            c = c.next;
        }
        return array;
    }

    public static int[][] linkedListsToArray(ListNode[] lists) {
        int[][] array = new int[lists.length][];
        for (int i = 0; i < lists.length; i++) {
            array[i] = linkedListToArray(lists[i]);
        }
        return array;
    }

    private static int getLength(ListNode head) {
        int length = 0;
        ListNode c = head;
        while (c != null) {
            length++;
            c = c.next;
        }
        return length;
    }


    public int val;
    public ListNode next;

    public ListNode() {
        this(0);
    }

    public ListNode(int val) {
        this(val ,null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
