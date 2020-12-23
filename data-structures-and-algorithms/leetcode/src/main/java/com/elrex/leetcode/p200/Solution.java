package com.elrex.leetcode.p200;

import com.elrex.leetcode.utils.IO;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: 200. Number of Islands
 * @see <a href="https://leetcode.com/problems/number-of-islands/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/12/18.
 */
public class Solution {

    private final static int DIRECTIONS = 4;
    private final static int[] XD = {1, 0, -1, 0};
    private final static int[] YD = {0, 1, 0, -1};

    /**
     *  Time complexity: O(M * N) where
     *      M is the number of rows in grid
     *      N is the number of columns in grid
     *  Space complexity: O(M * N) where
     *      M is the number of rows in grid
     *      N is the number of columns in grid
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    lookup(grid, m, n, i, j);
                }
            }
        }
        return islands;
    }

    private void lookup(char[][] grid, int m, int n, int x, int y) {
        if (x < 0 || x >= m ||
            y < 0 || y >= n ||
            grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '0';
        for (int i = 0; i < DIRECTIONS; i++) {
            int nx = x + XD[i];
            int ny = y + YD[i];
            lookup(grid, m, n, nx, ny);
        }
    }

    /**
     *  Time complexity: O(M * N) where
     *      M is the number of rows in grid
     *      N is the number of columns in grid
     *  Space complexity: O(M * N) where
     *      M is the number of rows in grid
     *      N is the number of columns in grid
     */
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int islands = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Point> queue = new LinkedList<Point>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '1') continue;
                islands++;
                grid[i][j] = '0';
                queue.offer(new Point(i, j));
                while (!queue.isEmpty()) {
                    Point p = queue.poll();
                    for (int d = 0; d < DIRECTIONS; d++) {
                        int nx = p.x + XD[d];
                        int ny = p.y + YD[d];
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1') {
                            grid[nx][ny] = '0';
                            queue.offer(new Point(nx, ny));
                        }
                    }
                }
            }
        }
        return islands;
    }

    private static class Point {
        public int x = 0;
        public int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     *  Time complexity: O(M * N) where
     *      M is the number of rows in grid
     *      N is the number of columns in grid
     *  Space complexity: O(M * N) where
     *      M is the number of rows in grid
     *      N is the number of columns in grid
     */
    public int numIslands3(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)  return 0;
        int m = grid.length;
        int n = grid[0].length;

        UnionSet set = new UnionSet(m * n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') continue;
                if (i + 1 < m && grid[i + 1][j] == '1') {
                    set.union(i * n + j, (i + 1) * n + j);
                }
                if (i - 1 >= 0 && grid[i - 1][j] == '1') {
                    set.union(i * n + j, (i - 1) * n + j);
                }
                if (j + 1 < n && grid[i][j + 1] == '1') {
                    set.union(i * n + j, i * n + (j + 1));
                }
                if (j - 1 >= 0 && grid[i][j - 1] == '1') {
                    set.union(i * n + j, i * n + (j - 1));
                }
            }
        }

        boolean[] checked = new boolean[m * n];
        int islands = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    int p = set.find(i * n + j);
                    if (!checked[p]) {
                        islands++;
                    }
                    checked[p] = true;
                }
            }
        }
        return islands;
    }

    private static class UnionSet {
        private int[] parent;
        private int[] rank;
        private int n;

        public UnionSet(int n) {
            this.n = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            int v = p;
            while (v != parent[v]) {
                parent[v] = parent[parent[v]];
                v = parent[v];
            }
            return v;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return;

            if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else {
                parent[rootQ] = rootP;
                rank[rootP] += 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] input = GRID_1();
        // Output: 1
        IO.print(solution.numIslands(input));

        input = GRID_2();
        IO.print(solution.numIslands(input));
        // Output: 3

        IO.print(solution.numIslands2(GRID_1()));
        // Output: 1

        IO.print(solution.numIslands2(GRID_2()));
        // Output: 3

        IO.print(solution.numIslands3(GRID_1()));
        // Output: 1

        IO.print(solution.numIslands3(GRID_2()));
        // Output: 3
    }

    private static char[][] GRID_1() {
        return new char[][] {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
    }

    private static char[][]  GRID_2() {
        return new char[][] {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
    }
}
