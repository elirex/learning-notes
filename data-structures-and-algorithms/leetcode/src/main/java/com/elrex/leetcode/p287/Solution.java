package com.elrex.leetcode.p287;

/**
 * Problem: 287
 * @see <a href="https://leetcode.com/problems/find-the-duplicate-number/">link</a>
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/10/12.
 */
public class Solution {

    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length < 1) return -1;

        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]) swap(nums, i, nums[i] - 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) return nums[i];
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        if (nums == null || nums.length < 1) return -1;

        int fast = nums[nums[0]];
        int slow = nums[0];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        slow = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }


    private void swap(int[] aar, int i, int j) {
        int temp = aar[i];
        aar[i] = aar[j];
        aar[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inputs = new int[] {1, 3, 4, 2, 2};
        // Output: 2
        System.out.println(solution.findDuplicate(inputs));

        inputs = new int[] {3, 1, 3, 4, 2};
        // Output: 3
        System.out.println(solution.findDuplicate2(inputs));
    }
}
