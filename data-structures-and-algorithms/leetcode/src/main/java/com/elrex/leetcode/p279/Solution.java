package com.elrex.leetcode.p279;

import com.elrex.leetcode.utils.IO;

import java.util.*;

/**
 * Problem: 279. Perfect Squares
 * @see <a href="https://leetcode.com/problems/perfect-squares/">link</a>
 *
 * Dynamic program
 * Time complexity: O(N * sqr(N)) where N  is the input.
 * Space complexity: O(N) where N is the input.
 *
 * Breath-first Search
 * Time Complexity: O(N ^ (N + 1)) where N is the input.
 * Space complexity: O(N ^ N) where N is the input.
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/12/11.
 */
public class Solution {

    public int numSquares(int n) {
        if (n < 4) return n;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    private Map<Integer, Integer> mem = new HashMap<>();
    public int numSquares2(int n) {
        if (n < 4) return n;
        if (mem.containsKey(n)) return mem.get(n);
        int count = n;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min(count, numSquares2(n - i * i) + 1);
        }
        mem.put(n, count);
        return count;
    }

    public int numSquares3(int n) {
        if (n < 4) return n;
        int sqrRoot = (int) Math.sqrt(n);
        int[] perfectSquare = new int[sqrRoot];
        for (int i = 1; i <= sqrRoot; i++) {
            perfectSquare[i - 1] = i * i;
        }

        int level = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                for (int square : perfectSquare) {
                    int remain = num - square;
                    if (remain == 0) {
                        return level;
                    } else if (remain > 0 && !visited[remain - 1]) {
                        visited[remain - 1] = true;
                        queue.offer(remain);
                    } else if (remain < 0) {
                        break;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int input = 12;
        // Output = 3
        IO.print(solution.numSquares(input));

        IO.print(solution.numSquares2(input));

        IO.print(solution.numSquares3(input));
    }

}
