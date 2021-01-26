package com.elrex.leetcode.p39;

import com.elrex.leetcode.utils.IO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 39. Combination Sum
 * @see <a href="https://leetcode.com/problems/combination-sum-ii/solution/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2021/1/26.
 */
public class Solution {

    /**
     *  Time complexity: O(2^N), where N is the length of the candidates.
     *  Space complexity: O(N), where N is the length of the candidates.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Time complexity: O(N logN)
        combine(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void combine(int[] candidates, int remain, int start, List<Integer> combination, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
       for (int i = start; i < candidates.length; i++) {
           int pick = candidates[i];
           if (remain - pick < 0) continue;
            combination.add(pick);
            combine(candidates, remain - pick, i, combination, result);
            combination.remove(combination.size() - 1);
       }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Input:
        int[] candidates = new int[] {2, 3, 6, 7};
        int target = 7;
        // Output: [[2,2,3],[7]]
        IO.print(solution.combinationSum(candidates, target));
    }
}
