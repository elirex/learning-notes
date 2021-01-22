package com.elrex.leetcode.p47;

import com.elrex.leetcode.utils.IO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: 47. Permutations II
 * @see <a href="https://leetcode.com/problems/permutations-ii/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2021/1/22.
 */
public class Solution {

    /**
     * Time Complexity: O(N!) where N is the length of the input.
     * Space Complexity: O(N) where N is the length of the input.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] permuted = new int[nums.length];
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums); // Time complexity: O(N logN)
        permute(nums, permuted, 0, visited, result); // Time complexity: O(N!)
        return result;
    }

    private void permute(int[] nums, int[] permuted, int index, boolean[] visited, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : permuted) list.add(i);
            result.add(list);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) continue;
            visited[i] = true;
            permuted[index] = nums[i];
            permute(nums, permuted, index + 1, visited, result);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[] {1, 2, 1};
        // Output:  [[1,1,2], [1,2,1], [2,1,1]]
        IO.print(solution.permuteUnique(input));
    }
}
