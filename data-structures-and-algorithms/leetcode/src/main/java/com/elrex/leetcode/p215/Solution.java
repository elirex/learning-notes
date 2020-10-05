package com.elrex.leetcode.p215;

import java.util.Arrays;

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/8/13.
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int pos = partition(nums, start, end);
            if (pos < k - 1) start = pos + 1;
            else if (pos > k - 1) end = pos - 1;
            else return nums[pos];
        }
        return 0;
    }

    private int partition(int[] arr, int start, int end) {
        int pivotIdx = start + (end - start) / 2;
        int pivot = arr[pivotIdx];
        swap(arr, start, pivotIdx);
        int s = start + 1;
        int e = end;
         while (s <= e) {
             if (arr[s] > pivot) s++;
             else if (arr[e] < pivot) e--;
             else swap(arr, s++, e--);
         }
         swap(arr, start, e);
         return e;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] input =  new int[] {3, 2, 1, 5, 6, 4};
        int k = 2;
        // Output: 5
        System.out.println(solution.findKthLargest(input, k));

        input = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
        k = 4;
        // Output: 4
        System.out.println(solution.findKthLargest(input, k));
    }

}
