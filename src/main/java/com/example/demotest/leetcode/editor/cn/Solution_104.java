package com.example.demotest.leetcode.editor.cn;//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1380 👎 0

//frontendQuestionId: 104
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
class Solution_104 {
    public static int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int deep = 0;
        if (root == null) {
            return 0;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            deep++;
            while (len > 0) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
                len --;
            }
        }
        return deep;
    }

    public static void main(String[] args) {
//        TreeNode test = TestData.constructTree();
//        System.out.printf(maxDepth(test) + "");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
