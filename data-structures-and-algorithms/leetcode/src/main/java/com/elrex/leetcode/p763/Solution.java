package com.elrex.leetcode.p763;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 763. Partition Labels
 * @see <a href="https://leetcode.com/problems/partition-labels/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/9/3.
 */
public class Solution {

    public List<Integer> partitionLabels(String S) {
        int[] latterLast = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) { // O(n)
            latterLast[S.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int last = 0;
        int offset = 0;
        for (int i = 0; i < length; i++) { // O(n)
            last = Math.max(last, latterLast[S.charAt(i) - 'a']);
            if (i == last) {
                result.add(i - offset + 1);
                offset = i + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "ababcbacadefegdehijhklij";
        // Output: [9, 7, 8]
        System.out.println(solution.partitionLabels(input));
    }
}
