package com.elrex.leetcode.p378;

/**
 * Problem: 378. Kth Smallest Element in a Sorted Matrix
 * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/9/23.
 */
public class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left <= right) { // O(log(max - min))
            int mid = left + (right - left) / 2;
            int num = left;
            int count = 0;
            int i = 0, j = n - 1;
            while (i < n && j >= 0) { // O(n)
                if (matrix[i][j] > mid) {
                    j--;
                } else {
                    num = Math.max(num, matrix[i][j]);
                    count += (j + 1);
                    i++;
                }
            }
            if (count == k) return num;
            else if (count < k) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[][] {
                        {1, 5, 9},
                        {10, 11, 12},
                        {12, 13, 15}
                    };
        int k = 8;
        // Output: 13
        System.out.println(solution.kthSmallest(input, k));
    }

}
