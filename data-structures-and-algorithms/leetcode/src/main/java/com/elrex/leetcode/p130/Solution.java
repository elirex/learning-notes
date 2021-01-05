package com.elrex.leetcode.p130;

import com.elrex.leetcode.utils.IO;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: 130. Surrounded Regions
 * @see <a href="https://leetcode.com/problems/surrounded-regions/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2021/1/5.
 */
public class Solution {

    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     *  Time complexity: O(M * N), where M and N is board's rows and columns.
     *  Space complexity: O(M * N), where M and N is board's rows and columns.
     */
    public void solve(char[][] board) {
        if (board == null) return;
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                lookupDFS(board, m, n, i, 0);
            }
            if (board[i][n- 1] == 'O') {
                lookupDFS(board, m, n, i, n - 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                lookupDFS(board, m, n, 0, i);
            }
            if (board[m - 1][i] == 'O') {
                lookupDFS(board, m, n, m - 1, i);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void lookupDFS(char[][] board, int m, int n, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') return;
        board[x][y] = '#';
        for (int i = 0; i < directions.length; i++) {
            int dx = x + directions[i][0];
            int dy = y + directions[i][1];
            lookupDFS(board, m, n, dx, dy);
        }
    }


    /**
     *  Time complexity: O(M * N), where M and N is board's rows and columns.
     *  Space complexity: O(M * N), where M and N is board's rows and columns.
     */
    public void solve2(char[][] board) {
        if (board == null) return;
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') lookupBFS(board, m, n, i, 0);
            if (board[i][n - 1] == 'O') lookupBFS(board, m, n, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') lookupBFS(board, m, n, 0, j);
            if (board[m - 1][j] == 'O') lookupBFS(board, m, n, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void lookupBFS(char[][] board, int m, int n, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        board[x][y] = '#';
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < directions.length; i++) {
                int dx = p.x + directions[i][0];
                int dy = p.y + directions[i][0];
                if (dx < 0 || dx >= m || dy < 0 || dy >= n || board[x][y] != 'O') continue;
                board[dx][dy] = '#';
                queue.offer(new Point(dx, dy));
            }
        }
    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     *  Time complexity: O(M * N), where M and N is board's rows and columns.
     *  Space complexity: O(M * N), where M and N is board's rows and columns.
     */
    public void solve3(char[][] board) {
        if (board == null) return;
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;

        int boundryNode = m * n;
        DisjointSet set = new DisjointSet(m * n + 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    int node = i * n + j;
                    if (i == 0 || i == m - 1 || j == 0 || j == n -1) {
                        set.union(node, boundryNode);
                    } else {
                        for (int[] d : directions) {
                            int dx = i + d[0];
                            int dy = j + d[1];
                            if (dx < 0 || dx >= m || dy < 0 || dy >= n || board[dx][dy] != 'O') continue;
                            int neighborNode = dx * n + dy;
                            set.union(neighborNode, node);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && set.find(i * n + j) != set.find(boundryNode)) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    private static class DisjointSet {
        private final int[] parent;
        private int[] rank;
        private int size;

        public DisjointSet(int size) {
            this.size = size;
            parent = new int[size];
            rank = new int[size];

            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int v) {
            int p = v;
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return;

            if (rank[rootP] > rank[rootQ]) {
                parent[rootQ] = rootP;
            } else if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootP] = rootQ;
                rank[rootQ]++;
            }
            size--;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] input = getBoard();
        // Output:
            // {'X','X','X','X'}
            // {'X','X','X','X'}
            // {'X','X','X','X'}
            // {'X','O','X','X'}

        solution.solve(input);
        IO.print(input);

        input = getBoard();
        solution.solve2(input);
        IO.print(input);

        input = getBoard();
        solution.solve3(input);
        IO.print(input);
    }

    private static char[][] getBoard() {
        return new char[][] {
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
    }
}
