package com.elrex.leetcode.p565;

/**
 * Problem: 565. Array Nesting
 * @see <a herf="https://leetcode.com/problems/array-nesting/description/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/10/22.
 */
public class Solution {

    public int arrayNesting(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 0;
            int next = i;
            while (nums[next] != -1) {
                int tmp = nums[next];
                nums[next] = -1;
                next = tmp;
                len++;
            }
            result = Math.max(result, len);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] input = new int[] {5, 4, 0, 3, 1, 6, 2};
        // Output: 4
        System.out.println(solution.arrayNesting(input));

    }

}
