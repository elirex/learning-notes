package com.elrex.leetcode.p17;

import com.elrex.leetcode.utils.IO;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 17. Letter Combinations of a Phone Number
 * @see <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/"></a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2021/1/13.
 */
public class Solution {

    private String[] dict = new String[] {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    /**
     *  Time complexity: O(3^N * 4^M)
     *      where N is the number of digits in the input that maps to 3 letters,
     *      and M is the number of digits in the input that maps to 4 letters.
     *  Space complexity: O(3^N * 4^M)
     *      where N is the number of digits in the input that maps to 3 letters,
     *      and M is the number of digits in the input that maps to 4 letters.
     *
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty())  return result;
        char[] temp = new char[digits.length()];
        combine(digits, 0, temp, result);
        return result;
    }

    private void combine(String digits, int index, char[] temp, List<String> result) {
        if (index == digits.length()) {
            result.add(new String(temp));
            return;
        }
        String d = dict[Character.getNumericValue(digits.charAt(index))];
        for (char c : d.toCharArray()) {
            temp[index] = c;
            combine(digits, index + 1, temp, result);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "23";
        // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        IO.print(solution.letterCombinations(input));
    }
}
