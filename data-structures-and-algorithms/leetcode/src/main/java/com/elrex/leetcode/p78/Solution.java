package com.elrex.leetcode.p78;

import com.elrex.leetcode.utils.IO;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 78. Subsets
 * @see <a href="https://leetcode.com/problems/subsets/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2021/1/29.
 */
public class Solution {

    /**
     * Time complexity: O(N * 2^N) where N is the length of input.
     * Space complexity: O(N * 2^N) where N is the length of input.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void subsets(int[] nums, int start, List<Integer> subset, List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            subsets(nums, i + 1, subset, result);
            subset.remove(subset.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[] {1, 2, 3};
        // Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        IO.print(solution.subsets(input));
    }
}
