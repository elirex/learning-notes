package com.elrex.leetcode.p697;

/**
 * Problem: 697. Degree of an Array
 * @see <a href="https://leetcode.com/problems/degree-of-an-array/description/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/10/19.
 */
public class Solution {

    public int findShortestSubArray(int[] nums) {
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }

        int[] firstPos = new int[max + 1];
        int[] count = new int[max + 1];
        int degree = 1;
        int minLength = 1;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            count[n]++;
            if (count[n] == 1) {
                firstPos[n] = i;
            }
            if (count[n] > degree) {
                degree = count[n];
                minLength = i - firstPos[n] + 1;
            }  else if (count[n] == degree) {
                minLength = Math.min(minLength, i - firstPos[n] + 1);
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[] {1, 2, 2, 3, 1};
        // Output: 2
        System.out.println(solution.findShortestSubArray(input));

        input = new int[] {1, 2, 2, 3, 1};
        // Output: 6
        System.out.println(solution.findShortestSubArray(input));
    }

}
