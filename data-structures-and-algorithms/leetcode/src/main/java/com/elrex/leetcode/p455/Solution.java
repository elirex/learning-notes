package com.elrex.leetcode.p455;


import java.util.Arrays;

/**
 * Problem: 455. Assign Cookies
 *
 * @see <a href="https://leetcode.com/problems/assign-cookies/"></a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/8/24.
 */
public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0; count < g.length && i < s.length; i++) {
            if (s[i] >= g[count]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] children = new int[] {1, 2};
        int[] cookies = new int[] {1, 2, 3};
        System.out.println(solution.findContentChildren(children, cookies));
    }
}
