package com.elrex.leetcode.p633;

/**
 * Problem: 633. Sum of Square Numbers
 * @see <a href="https://leetcode.com/problems/sum-of-square-numbers/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/8/5.
 */
public class Solution {

    public boolean judgeSquareSum(int c) {
        if (c == 1) return true;
        long start = 0;
        long end = (long) (Math.sqrt(c) + 1);
        while (start <= end) {
            long sum = (start * start) + (end * end);
            if (sum == c) return true;
            else if (sum > c) end--;
            else start++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int input = 2;
        // Output: true
        System.out.println(solution.judgeSquareSum(input));

        input = 3;
        // Output: false
        System.out.println(solution.judgeSquareSum(input));

        input = 5;
        // Output: true
        System.out.println(solution.judgeSquareSum(input));
    }

}
