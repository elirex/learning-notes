package com.elrex.leetcode.p665;

/**
 * Problem: 665. Non-decreasing Array
 * @see <a href="https://leetcode.com/problems/non-decreasing-array/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/9/3.
 */
public class Solution {

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (++count > 1) return false;
                if (i - 1 < 0 || nums[i - 1] <= nums[i + 1]) {
                    nums[i] = nums[i + 1];
                } else {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[] {4, 2, 3};
        // Output: true
        System.out.println(solution.checkPossibility(input));

        input = new int[] {4, 2, 1};
        // Output: false
        System.out.println(solution.checkPossibility(input));
    }
}
