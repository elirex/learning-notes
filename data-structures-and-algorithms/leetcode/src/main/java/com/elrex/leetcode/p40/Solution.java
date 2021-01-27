package com.elrex.leetcode.p40;

import com.elrex.leetcode.utils.IO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 40. Combination Sum II
 * @see <a href="https://leetcode.com/problems/combination-sum-ii/description/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2021/1/27.
 */
public class Solution {

    /**
     *  Time complexity: O(K * 2^N), where K is the average length of each possible solution, N the number of candidate.
     *  Space complexity: (N) where N is the recursion stack.
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combine(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void combine(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (i > start && candidates[i - 1] == candidate) continue;
            if (target - candidate < 0) continue;
            combination.add(candidate);
            combine(candidates, target - candidate, i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // Input:
        int[] candidates = new int[] {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        // Output: [[1,1,6], [1,2,5], [1,7], [2,6]]
        IO.print(solution.combinationSum2(candidates, target));
    }
}
