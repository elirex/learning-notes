package com.elrex.leetcode.p452;

import java.util.Arrays;

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/8/28.
 */

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> (a[0] - b[0]));
        int count = 1;
        int last = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= points[last][1]) {
                if (points[last][1] > points[i][1]) last = i;
            } else {
                count++;
                last = i;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        // Output: 2
        System.out.println(solution.findMinArrowShots(input));
    }
}
