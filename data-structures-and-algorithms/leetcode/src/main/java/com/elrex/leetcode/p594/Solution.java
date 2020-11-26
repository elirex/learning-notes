package com.elrex.leetcode.p594;

import com.elrex.leetcode.utils.IO;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: 594. Longest Harmonious Subsequence
 * @see <a href="https://leetcode.com/problems/longest-harmonious-subsequence/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/11/26.
 */
public class Solution {

    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int length = 0;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            if (map.containsKey(n + 1)) {
                length = Math.max(length, map.get(n) + map.get(n + 1));
            }
            if (map.containsKey(n - 1)) {
                length = Math.max(length, map.get(n) + map.get(n - 1));
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[] {1, 3, 2, 2, 5, 2, 3, 7};
        // Output: 5
        IO.print(solution.findLHS(input));

        input = new int[] {1, 2, 3, 4};
        // Output: 2
        IO.print(solution.findLHS(input));
    }
}
