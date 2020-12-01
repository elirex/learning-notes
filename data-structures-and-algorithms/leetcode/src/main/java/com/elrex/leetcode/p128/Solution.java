package com.elrex.leetcode.p128;

import com.elrex.leetcode.utils.IO;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: 128. Longest Consecutive Sequence
 * @see <a href="https://leetcode.com/problems/longest-consecutive-sequence/">link</a>
 * Time Complexity: O(n), n is the length of nums.
 * Space Complexity: O(n), n is the length of nums.
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/12/1.
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0 ) return 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // Time Complexity: O(n), where n is the length of nums
        // Space Complexity: O(n), where n is the length of nums.
        for (int n : nums) {
            if (map.containsKey(n)) continue;
            int left = map.getOrDefault(n - 1, 0);
            int right = map.getOrDefault(n + 1, 0);
            int length = left + right + 1;
            result = Math.max(result, length);
            map.put(n, length);
            map.put(n - left, length);
            map.put(n + right, length);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] inputs = new int[] {100, 4, 200, 1, 3, 2};
        // Output: 4
        IO.print(solution.longestConsecutive(inputs));

        inputs = new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0 ,1};
        // Output: 9
        IO.print(solution.longestConsecutive(inputs));
    }
}
