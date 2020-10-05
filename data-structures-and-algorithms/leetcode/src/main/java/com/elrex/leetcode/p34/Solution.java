package com.elrex.leetcode.p34;

import java.util.Arrays;

/**
 * Problem: 34. Find First and Last Position of Element in Sorted Array
 * @see <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/9/15.
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1, -1};
        return new int[] {lowerBound(nums, target), upperBound(nums, target)};
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }

    private int upperBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[] {5, 7, 7, 8, 8, 10};
        int target = 8;
        // Output: [3, 4]
        System.out.println(Arrays.toString(solution.searchRange(input, target)));

        input = new int[] {5, 7, 7, 8, 8, 10};
        target = 6;
        // Output: [-1, -1]
        System.out.println(Arrays.toString(solution.searchRange(input, target)));

    }
}
