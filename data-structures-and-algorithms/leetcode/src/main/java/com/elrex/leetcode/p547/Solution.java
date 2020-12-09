package com.elrex.leetcode.p547;

import com.elrex.leetcode.utils.IO;

import java.util.Stack;

/**
 * Problem: 547. Friend Circles
 * @see <a href="https://leetcode.com/problems/friend-circles/">link</a>
 *
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/12/9.
 */
public class Solution {

    /**
     * Time complexity: O(N * N) where N is the number of the students.
     * Space complexity: O(N) where N is the number of the students.
     */
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        boolean[] checked = new boolean[M.length];
        int groupCount = 0;
        for (int i = 0; i < M.length; i++) {
            if (!checked[i]) {
                groupCount++;
                findCircleNum(M, checked, i);
            }
        }
        return groupCount;
    }

    private void findCircleNum(int[][] M, boolean[] checked, int self) {
        for (int other = 0; other < M.length; other++) {
            if (M[self][other] == 1 && !checked[other]) {
                checked[other] = true;
                findCircleNum(M, checked, other);
            }
        }
    }

    /**
     * Time complexity: O(N * N) where N is the number of the students.
     * Space complexity: O(N) where N is the number of the students.
     */
    public int findCircleNum2(int[][] M) {
        if (M == null || M.length == 0) return 0;
        boolean[] checked = new boolean[M.length];
        int groupCount = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < M.length; i++) {
            if (!checked[i]) {
                groupCount++;
                stack.push(i);
                while (!stack.isEmpty()) {
                    int self = stack.pop();
                    for (int other = 0; other < M.length; other++) {
                        if (M[self][other] == 1 && !checked[other]) {
                            checked[other] = true;
                            stack.push(other);
                        }
                    }
                }
            }
        }
        return groupCount;
    }

    /**
     * Time complexity: O(N * N * logN) where N is the number of the students.
     * Space complexity: O(N) where N is the number of the students.
     */
    public int findCircleNum3(int[][] M) {
        if (M == null || M.length == 0) return 0;
        UnionFind uf = new UnionFind(M.length);
        for (int i = 0; i < M.length - 1; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 1) uf.union(i , j);
            }
        }
        return uf.count();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        // Output: 2
        IO.print(solution.findCircleNum(input));

        IO.print(solution.findCircleNum2(input));

        input = new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        // Output: 1
        IO.print(solution.findCircleNum3(input));
    }

    private static class UnionFind {
        private int count = 0;
        private final int[] parent;
        private final int[] rank;

        UnionFind(int n) {
            count = n;
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int p) {
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

            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
                rank[rootQ] += rank[rootP];
            } else {
                parent[rootQ] = rootP;
                rank[rootP] += rank[rootQ];
            }
            count--;
        }

        public int count() {
            return count;
        }
    }
}
