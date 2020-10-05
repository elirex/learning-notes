package com.elrex.leetcode.p347;

import java.util.*;

/**
 * Problem: 347. Top K Frequent Elements
 * @see <a herf="https://leetcode.com/problems/top-k-frequent-elements/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/8/19.
 */
public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int n : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(n);
            if (buckets[frequency] == null) buckets[frequency] = new ArrayList<Integer>();
            buckets[frequency].add(n);
        }

        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] == null) continue;
            if (buckets[i].size() <= (k - topK.size())) topK.addAll(buckets[i]);
            else topK.addAll(buckets[i].subList(0, (k - topK.size())));
        }
        return topK.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[] {1, 1, 1, 2, 2, 3};
        int k = 2;
        // Output: [1, 2]
        System.out.println(Arrays.toString(solution.topKFrequent(input, k)));

        input = new int[] {1};
        k = 1;
        // Output: [1]
        System.out.println(Arrays.toString(solution.topKFrequent(input, k)));
    }

}
