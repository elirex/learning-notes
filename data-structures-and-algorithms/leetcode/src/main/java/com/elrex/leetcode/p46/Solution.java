package com.elrex.leetcode.p46;

import com.elrex.leetcode.utils.IO;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 46. Permutations
 * @see <a href="https://leetcode.com/problems/permutations/>link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2021/1/20.
 */
public class Solution {

    /**
     * Time complexity: O(N), where N is the length of the input array.
     * Space complexity: O(N), where N is the length of the input array.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, new boolean[nums.length], new int[nums.length], 0, result);
        return result;
    }

    private void permute(int[] nums, boolean[] visited, int[] permuted, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> list = new ArrayList<>(permuted.length);
            for (int i : permuted) {
                list.add(i);
            }
            result.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            permuted[index] = nums[i];
            permute(nums, visited, permuted, index + 1, result);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[] {1, 2, 3};
        // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        IO.print(solution.permute(input));
    }
}
