package com.elrex.leetcode.p241;

import com.elrex.leetcode.utils.IO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: 241. Different Ways to Add Parentheses
 * @see <a href="https://leetcode.com/problems/different-ways-to-add-parentheses/">link</a>
 *
 * Explain time complexity: https://stackoverflow.com/questions/27371612/catalan-numbers-recursive-function-time-complexity/27374250#27374250
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/12/3.
 */
public class Solution {

    // Time Complexity: O(3^n)
    // Space Complexity: O(3^n)
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int a : left) {
                    for (int b : right) {
                        if (c == '+') result.add(a + b);
                        else if (c == '-') result.add(a - b);
                        else result.add(a * b);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }

    // Time Complexity: O(2^n)
    // Space Complexity: O(2^n)
    private Map<String, List<Integer>> mem = new HashMap<>();
    public List<Integer> diffWaysToCompute2(String input) {
        if (mem.containsKey(input)) return mem.get(input);
        List<Integer> result = new ArrayList<>();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute2(input.substring(0, i));
                List<Integer> right = diffWaysToCompute2(input.substring(i + 1));
                for (int a : left) {
                    for (int b : right) {
                        if (c == '+')  result.add(a + b);
                        else if (c == '-') result.add(a - b);
                        else result.add(a * b);
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        mem.put(input, result);
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "2-1-1";
        // Output: [0, 2]
        IO.print(solution.diffWaysToCompute(input));

        input = "2*3-4*5";
        // Output: [-34, -14, -10, -10, 10]
        IO.print(solution.diffWaysToCompute2(input));
    }
}
