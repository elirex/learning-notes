package com.elrex.leetcode.p451;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/8/23.
 */
public class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer>  frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (char c : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(c);
            if (buckets[frequency] == null) buckets[frequency] = new ArrayList<>();
            buckets[frequency].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) continue;
            for (char c : buckets[i]) {
                for (int j = 0; j < i; j++) sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "tree";
        // Output: eert
        System.out.println(solution.frequencySort(input));

        input = "cccaaa";
        // Output: cccaaa
        System.out.println(solution.frequencySort(input));
    }

}
