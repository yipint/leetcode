package com.example.demotest.leetcode.editor.cn;//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2375 👎 0

//frontendQuestionId: 101
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution_101 {
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compareNode(root);
    }

    public static boolean compareNode(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left != null && right != null && left.val != right.val) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else {
            return compareNode(left.left, right.right) && compareNode(left.right, right.left);
        }
    }


    //普通迭代法
    //按照比较顺序
    public static boolean compareNode(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if (right == null || left == null || left.val != right.val) {
                return false;
            }
            queue.add(right.right);
            queue.add(left.left);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(1);
        root.left = left;
        root.right = right;
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode right1 = new TreeNode(3);
        TreeNode right2 = new TreeNode(2);
        left.left = left1;
        left.right = left2;
        right.left = right1;
        right.right = right2;
        System.out.printf("" + isSymmetric(root));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
