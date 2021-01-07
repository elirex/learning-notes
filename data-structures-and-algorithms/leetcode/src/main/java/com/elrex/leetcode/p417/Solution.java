package com.elrex.leetcode.p417;

import com.elrex.leetcode.utils.IO;

import java.util.*;

/**
 * Problem: 417. Pacific Atlantic Water Flow
 * @see <a href="https://leetcode.com/problems/pacific-atlantic-water-flow/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2021/1/7.
 */
public class Solution {

    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     *  Time complexity: O(M*N), where M is matrix's rows, N is matrix's columns.
     *  Space complexity: O(M*N), where M is matrix's rows, N is matrix's columns.
     */ 
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null) return result;
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        if (n == 0) return result;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            lookupDFS(matrix, m, n, 0, i, 0, pacific); // left
            lookupDFS(matrix, m, n, 0, i, n - 1, atlantic); // right
        }

        for (int i = 0; i < n; i++) {
            lookupDFS(matrix, m, n, 0, 0, i, pacific); // top
            lookupDFS(matrix, m, n, 0, m - 1, i, atlantic); // bottom
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }

    private void lookupDFS(int[][] matrix, int m, int n, int h,
                           int x, int y, boolean[][] visited) {
        if (x < 0 || x >= m || y < 0 || y >= n) return;
        if (visited[x][y] || matrix[x][y] < h) return;
        visited[x][y] = true;
        for (int[] d : directions) {
            lookupDFS(matrix, m, n, matrix[x][y], x + d[0], y + d[1], visited);
        }
    }

    /**
     *  Time complexity: O(M*N), where M is matrix's rows, N is matrix's columns.
     *  Space complexity: O(M*N), where M is matrix's rows, N is matrix's columns.
     */
    public List<List<Integer>> pacificAtlantic2(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null) return result;
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        if (n == 0) return result;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<Point> queueP = new LinkedList<>();
        Queue<Point> queueA = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            queueP.offer(new Point(i, 0)); // left
            queueA.offer(new Point(i, n - 1)); // right
        }
        
        for (int i = 0; i < n; i++) {
            queueP.offer(new Point(0, i)); // top
            queueA.offer(new Point(m - 1, i)); // bottom
        }
        lookupBFS(matrix, m, n, queueP, pacific);
        lookupBFS(matrix, m, n, queueA, atlantic);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }
    
    private void lookupBFS(int[][] matrix, int m, int n, Queue<Point> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (visited[p.x][p.y]) continue;
            visited[p.x][p.y] = true; 
            for (int[] d : directions) {
                int dx = p.x + d[0];
                int dy = p.y + d[1];
                if (dx < 0 || dx >= m || dy < 0 || dy >= n ||
                    matrix[dx][dy] < matrix[p.x][p.y] || visited[dx][dy]) continue;
                queue.offer(new Point(dx, dy));
            }
        }
    }
    
    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     *  Time complexity: O(M*N), where M is matrix's rows, N is matrix's columns.
     *  Space complexity: O(M*N), where M is matrix's rows, N is matrix's columns.
     */
    public List<List<Integer>> pacificAtlantic3(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null) return result;
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        if (n == 0) return result;

        int[][] visited = new int[m][n];

        for (int i = 0; i < m; i++) {
            visited[i][0] |= PACIFIC; // left
            visited[i][n - 1] |= ATLANTIC; // right
        }

        for (int i = 0; i < n; i++) {
            visited[0][i] |= PACIFIC; // top
            visited[m - 1][i] |= ATLANTIC; // bottom
        }

        while (true) {
            boolean changed = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] d : directions) {
                        int dx = i + d[0];
                        int dy = j + d[1];
                        if (dx < 0 || dx >= m || dy < 0 || dy >= n || matrix[i][j] < matrix[dx][dy] ||
                            (visited[i][j] | visited[dx][dy]) == visited[i][j]) continue;
                        visited[i][j] |= visited[dx][dy];
                        changed = true;
                    }
                }
            }
            if (!changed) break;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == PACIFIC_AND_ATLANTIC) result.add(Arrays.asList(i , j));
            }
        }
        return result;
    }
    
    private static final int PACIFIC = 1;
    private static final int ATLANTIC = 2;
    private static final int PACIFIC_AND_ATLANTIC = 3;

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[][] {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        // Output: [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
        IO.print(solution.pacificAtlantic(input));

        // Output: [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
        IO.print(solution.pacificAtlantic2(input));

        // Output: [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
        IO.print(solution.pacificAtlantic3(input));
    }
}
