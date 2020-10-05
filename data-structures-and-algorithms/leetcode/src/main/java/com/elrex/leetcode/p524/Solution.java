package com.elrex.leetcode.p524;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/8/12.
 */
public class Solution {

    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String str : d) {
            if ((str.length() > longest.length() || (str.length() == longest.length()
                    && str.compareTo(longest) < 0)) && isSubstring(str, s)) {
                longest = str;
            }
        }
        return longest;
    }

    private boolean isSubstring(String a, String b) {
        int i = -1;
        int j = -1;
        while (++i < a.length()) {
            if ((j = b.indexOf(a.charAt(i), j + 1)) == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abpcplea";
        List<String> d = Arrays.asList("ale", "apple", "monkey", "plea");
        // Output: apple
        System.out.println(solution.findLongestWord(s, d));

        s = "abpclea";
        d = Arrays.asList("a", "b", "c");
        // Output: a
        System.out.println(solution.findLongestWord(s, d));
    }

}
