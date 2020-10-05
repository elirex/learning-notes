package com.elrex.leetcode.p645;

import java.util.Arrays;

/**
 * Problem: 645. Set Mismatch
 * @see <a href="https://leetcode.com/problems/set-mismatch/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/10/5.
 */
public class Solution {

    public int[] findErrorNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) swap(nums, i, nums[i] - 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return new int[] {nums[i] , i + 1};
        }
        return new int[] {};
    }

    public int[] findErrorNums2(int[] nums) {
        int[] result = new int[2];
        for (int n : nums) {
            int t = Math.abs(n);
            if (nums[t - 1] < 0) result[0] = t;
            else nums[t - 1] *= - 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[1] = i + 1;
                return result;
            }
        }
        return new int[] {};
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[] {1, 2, 2, 4};
        // Output: [2, 3]

        System.out.println(Arrays.toString(solution.findErrorNums(input)));

        input = new int[] {3, 2, 4, 2};
        // Output: [2, 1]
        System.out.println(Arrays.toString(solution.findErrorNums2(input)));

    }

}
