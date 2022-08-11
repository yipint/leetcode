package com.example.demotest.leetcode.editor.cn;

/**
 * @author tianyipin
 * @desc
 * @since 2022/6/23
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

//    public static TreeNode constructTree() {
//        TreeNode left = new TreeNode(2);
//        left.left = new TreeNode(4);
//        left.right = new TreeNode(5);
//
//        TreeNode right = new TreeNode(3);
//        right.left = new TreeNode(6);
//        right.right = new TreeNode(7);
//
//        TreeNode root = new TreeNode(1);
//        root.left = left;
//        root.right = right;
//        return root;
//    }


}
