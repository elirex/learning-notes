package com.elrex.leetcode.p566;

import java.util.Arrays;

/**
 * Problem: 566. Reshape the Matrix
 * @see <a href=https://leetcode.com/problems/reshape-the-matrix/>link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/9/21.
 */
public class Solution {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || (r * c) != (nums.length * nums[0].length)) return nums;

        int[][] matrix = new int[r][c];
        int rows = nums.length;
        int columns = nums[0].length;
        int index = 0;
        for (int i = 0; i < rows; i++) { // O(m * n)
            for  (int j = 0; j < columns; j++) {
                matrix[index / c][index % c] = nums[i][j];
                index++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[][] {{1, 2}, {3, 4}};
        int r = 1, c = 4;
        // Output: [[1, 2, 3, 4]
        System.out.println(Arrays.deepToString(solution.matrixReshape(input, r, c)));

        input = new int[][] {{1, 2}, {3, 4}};
        r = 2;
        c = 4;
        // Output: [[1, 2], [3, 4]]
        System.out.println(Arrays.deepToString(solution.matrixReshape(input, r, c)));
    }
}
