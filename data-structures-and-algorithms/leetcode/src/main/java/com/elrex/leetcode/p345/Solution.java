package com.elrex.leetcode.p345;

/**
 * Problem: 345. Reverse Vowels of a String
 * @see <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/8/5.
 */
public class Solution {

    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] reversed = s.toCharArray();
        while (start < end) {
            if (isVowels(reversed[start]) && isVowels(reversed[end])) {
                if (reversed[start] != reversed[end]) {
                    char temp = reversed[start];
                    reversed[start] = reversed[end];
                    reversed[end] = temp;
                }
                start++;
                end--;
            } else {
                while (start < reversed.length && !isVowels(reversed[start])) start++;
                while (end > 0 && !isVowels(reversed[end])) end--;
            }
        }
        return new String(reversed);
    }

    private boolean isVowels(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'  ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "hello";
        // Output: holle
        System.out.println(solution.reverseVowels(input));

        input = "leetcode";
        // Output: leotcede
        System.out.println(solution.reverseVowels(input));
    }
}
