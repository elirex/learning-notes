package com.elrex.leetcode.p53;

/**
 * Problem: 53. Maximum SubArray
 * @see <a href="https://leetcode.com/problems/maximum-subarray/">link</a>
 *
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/9/3.
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int maxSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) sum = nums[i];
            else sum += nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // Output: 6
        // Explanation: [4, -1, 2, 1];
        System.out.println(solution.maxSubArray(input));
    }
}
