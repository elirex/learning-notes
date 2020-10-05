package com.elrex.leetcode.p435;

import java.util.Arrays;

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/8/25.
 */
public class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int count = 0;
        int last = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[last][1] > intervals[i][0]) {
                // Overlapping
                count++;
                if (intervals[last][1] > intervals[i][1]) last = i;
            } else {
                // Non-overlapping
                last = i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        // Output: 1
        System.out.println(solution.eraseOverlapIntervals(input));

        input = new int[][] {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(solution.eraseOverlapIntervals(input));
        // Output: 2
    }
}
