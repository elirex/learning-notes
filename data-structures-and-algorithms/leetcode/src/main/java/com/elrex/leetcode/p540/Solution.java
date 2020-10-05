package com.elrex.leetcode.p540;

/**
 * Problem: 540. Single Element in a Sorted Array
 * @see <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/9/8.
 */
public class Solution {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // left equal to right that represents find the appear once element.
        while (left < right) { // O(log n)
            int m = left + (right - left) / 2;

            // Below the logical means is
            // if m is even then n = m + 1
            // else m is odd then n = m - 1
            int n = m ^ 1;
            if (nums[m] == nums[n]) left = m + 1;
            else right = m;
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution solution  = new Solution();
        int[] input = new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8};
        // Output: 2
        System.out.println(solution.singleNonDuplicate(input));

        input = new int[] {3, 3, 7, 7, 10, 11, 11};
        // Output: 10
        System.out.println(solution.singleNonDuplicate(input));
    }
}
