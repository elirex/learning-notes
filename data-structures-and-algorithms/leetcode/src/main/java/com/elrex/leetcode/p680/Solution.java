package com.elrex.leetcode.p680;

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/8/6.
 */
public class Solution {

    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(s, start + 1, end) ||
                       isPalindrome(s, start, end - 1);
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.validPalindrome("abca"));
    }
}
