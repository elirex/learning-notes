package com.elrex.leetcode.p240;

/**
 * Problem: 240. Search a 2D Matrix II
 * @see <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/9/21.
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        // Time complexity: O(m * n)
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--;
            else row++;
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        for (int[] arr : matrix) {
            int left = 0;
            int right = arr.length -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) return true;
                else if (arr[mid] > target) right = mid - 1;
                else left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 5;
        // Output: true
        System.out.println(solution.searchMatrix(input, target));

        target = 20;
        // Output: false
        System.out.println(solution.searchMatrix2(input, target));

    }
}
