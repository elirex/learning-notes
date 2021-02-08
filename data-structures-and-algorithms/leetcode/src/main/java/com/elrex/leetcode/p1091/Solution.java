package com.elrex.leetcode.p1091;

import com.elrex.leetcode.utils.IO;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: 1091. Shortest Path in Binary Matrix
 * @see <a href="https://leetcode.com/problems/shortest-path-in-binary-matrix/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2021/2/8.
 */
public class Solution {

    private static final int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
            {1, -1},
            {-1, 1},
            {1, 1},
            {-1, -1}
    };

    /**
     * Time complexity: O(M * N), where M and N are the rows of grid and the columns of grid.
     * Space complexity: O(M * N), where M and N are the rows of grid and the columns of grid.
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = -1;
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] p = queue.poll();
                if (p[0] == m - 1 && p[1] == n - 1) {
                    return step + 1;
                }
                for (int[] d : directions) {
                    int nX = p[0] + d[0];
                    int nY = p[1] + d[1];
                    if (nX >= 0 && nX < m && nY >= 0 && nY < n && grid[nX][nY] == 0) {
                        queue.offer(new int[] {nX, nY});
                        grid[nX][nY] = -1;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[][] {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        // Output: 4
        IO.print(solution.shortestPathBinaryMatrix(input));
    }
}
