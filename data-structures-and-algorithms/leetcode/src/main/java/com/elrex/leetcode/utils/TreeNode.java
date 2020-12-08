package com.elrex.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wang, Sheng-Yuan (Elirex) on 2020/12/8.
 */
public class TreeNode {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        preorderTraversal(root, traversal);
        return traversal;
    }

    private static void preorderTraversal(TreeNode root, List<Integer> traversal) {
        if (root == null) {
            traversal.add(null);
            return;
        }
        traversal.add(root.val);
        preorderTraversal(root.left, traversal);
        preorderTraversal(root.right, traversal);
    }

    public int val = 0;

    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode() {
        this(0);
    }

    public TreeNode(int val) {
        this(val, null, null);
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
