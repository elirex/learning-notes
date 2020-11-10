package com.elrex.leetcode.p769;

/**
 * Problem: 769. Max Chunks To Make Sorted
 * @see <a href="https://leetcode.com/problems/max-chunks-to-make-sorted/description/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/10/28.
 */
public class Solution {

    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int[] max = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) max[i] = arr[i];
            else max[i] = Math.max(max[i - 1], arr[i]);
        }
        int chunksCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max[i] == i) chunksCount++;
        }
        return chunksCount;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[] {4, 3, 2, 1, 0};
        // Output = 1
        System.out.println(solution.maxChunksToSorted(input));

        input = new int[] {1, 0, 2, 3, 4};
        // Output = 4
        System.out.println(solution.maxChunksToSorted(input));
    }

}
