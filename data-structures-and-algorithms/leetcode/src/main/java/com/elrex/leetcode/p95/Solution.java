package com.elrex.leetcode.p95;

import com.elrex.leetcode.utils.IO;
import com.elrex.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/12/8.
 */
public class Solution {


    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateTrees(1, n);
    }
    /**
     * Time complexity: O(3^N) where N is the input.
     * Space complexity: O(3^N) where N is the input.
     *
     * Trees(n) =
     *      Trees(0) * Trees(n-1) +
     *      Trees(1) * Trees(n-2) +
     *      Trees(2) * Trees(n-3) +
     *      Trees(3) * Trees(n-4) +
     *      ...
     *      Trees(n-2) * Tress(1) +
     *      Trees(n-1) * Trees(0)
     *
     * Trees(0) = 1
     *
     * Trees(1) =
     *      Trees(0) * Trees(0)
     *          = 1
     *
     * Trees(2) =
     *      Trees(0) * Trees(1) +
     *      Trees(1) * Trees(0)
     *          = 2
     *
     * Trees(3) =
     *      Trees(0) * Trees(2) +
     *      Trees(1) * Trees(1) +
     *      Trees(2) * Trees(0) +
     *          = 5
     *
     * Trees(4) =
     *      Trees(0) * Trees(3) +
     *      Trees(1) * Trees(2) +
     *      Trees(2) * Trees(1) +
     *      Trees(3) * Trees(0) +
     *          = 14
     *
     */
    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i, left, right);
                    result.add(root);
                }
            }
        }
        return result;
    }

    public List<TreeNode> generateTrees2(int n) {
        if (n == 0) return new ArrayList<>();
        List<TreeNode>[] dp = new List[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(null);

        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<>();
            for (int root = 1; root <= len; root++) {
                int leftLen = root - 1;
                int rightLen = len - root;
                for (TreeNode leftTree : dp[leftLen]) {
                    for (TreeNode rightTree : dp[rightLen]) {
                        TreeNode node = new TreeNode(root, leftTree, clone(rightTree, root));
                        dp[len].add(node);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode clone(TreeNode root, int delta) {
        if (root == null) return root;
        TreeNode node = new TreeNode(root.val + delta, clone(root.left, delta), clone(root.right, delta));
        return node;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int input = 3;
        // Output:
        // [
        //   [1,null,3,2],
        //   [3,2,null,1],
        //   [3,1,null,null,2],
        //   [2,1,3],
        //   [1,null,2,null,3]
        // ]

        List<List<Integer>> output = new ArrayList<>();
        for (TreeNode root : solution.generateTrees(input)) {
            output.add(TreeNode.preorderTraversal(root));
        }
        IO.print(output);

       output = new ArrayList<>();
        for (TreeNode root : solution.generateTrees2(input)) {
            output.add(TreeNode.preorderTraversal(root));
        }
        IO.print(output);
    }
}
