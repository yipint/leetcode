package com.example.demotest.leetcode.editor.cn;

/**
 * @author tianyipin
 * @desc
 * @since 2022/7/8
 */
public class TestData {
    public static TreeNode constructTree() {
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);

        TreeNode right = new TreeNode(3);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);

        TreeNode root = new TreeNode(1);
        root.left = left;
        root.right = right;
        return root;
    }

    public static TreeNode constructSearchTree() {
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(1);
        left.right = new TreeNode(3);

        TreeNode right = new TreeNode(6);
        right.left = new TreeNode(5);
        right.right = new TreeNode(7);

        TreeNode root = new TreeNode(4);
        root.left = left;
        root.right = right;
        return root;
    }

//    public static Node constructNode() {
//        Node left = new Node(2);
//        left.left = new Node(4);
//        left.right = new Node(5);
//
//        Node right = new Node(3);
//        right.left = new Node(6);
//        right.right = new Node(7);
//
//        Node root = new Node(1);
//        root.left = left;
//        root.right = right;
//        return root;
//    }


}
