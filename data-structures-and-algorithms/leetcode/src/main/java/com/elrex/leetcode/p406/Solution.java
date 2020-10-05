package com.elrex.leetcode.p406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/8/27.
 */
public class Solution {

    public int[][] reconstructQueue(int[][] people) {
        // Sort strategy
        // Person pair (h, k)
        // If two people have the same h then the person with the smaller k
        // will be in front of the other person,
        // else the person with the higher h will be in front of the other person.
        // O(n log n)
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));

        // According to the k to reconstruction the queue.
        List<int[]> queue = new ArrayList<>();
        for (int[] person : people) { // O(n)
            queue.add(person[1], person);
        }
        return queue.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] input = new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        // Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
        System.out.println(Arrays.deepToString(solution.reconstructQueue(input)));
    }
}
