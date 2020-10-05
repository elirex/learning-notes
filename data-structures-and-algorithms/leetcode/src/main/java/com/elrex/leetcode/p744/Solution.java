package com.elrex.leetcode.p744;

/**
 * Problem: 744. Find Smallest Letter Greater Than Target
 * @see <a href="https://leetcode.com/problems/find-smallest-letter-greater-than-target/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/9/8.
 */
public class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        int left = 0;
        int right = length;

        while (left < right) { // O(log n)
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        //
        // return letters[left] where left != length and left = right
        // return letters[0] where left = length or left != right
        return letters[left % length];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] input = new char[] {'c', 'f', 'j'};
        char target = 'a';
        // Output: c
        System.out.println(solution.nextGreatestLetter(input, target));

        input = new char[] {'c', 'f', 'j'};
        target = 'c';
        // Output: f
        System.out.println(solution.nextGreatestLetter(input, target));

        input = new char[] {'c', 'f', 'j'};
        target = 'j';
        // Output: c
        System.out.println(solution.nextGreatestLetter(input, target));

        input = new char[] {'c', 'f', 'j'};
        target = 'k';
        // Output: c
        System.out.println(solution.nextGreatestLetter(input, target));
    }
}
