package com.elrex.leetcode.p153;

/**
 * Problem: 153. Find Minimum in Rotated Sorted Array
 * @see <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/9/10.
 */
public class Solution {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            // This represents the part of nums is sorted,
            // os return the left of element.
            if (nums[left] < nums[right]) return nums[left];

            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] input = new int[] {3, 4, 5, 1, 2};
        // Output: 1
        System.out.println(solution.findMin(input));

        input = new int[] {4, 5, 6, 7, 0, 1, 2};
        // Output: 0
        System.out.println(solution.findMin(input));
    }
}
