package com.example.demotest.leetcode.editor.cn;//给定二叉树的根节点 root ，返回所有左叶子之和。
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [3,9,20,null,null,15,7] 
//输出: 24 
//解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
// 
//
// 示例 2: 
//
// 
//输入: root = [1]
//输出: 0
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 1000] 范围内 
// -1000 <= Node.val <= 1000 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 617 👎 0

//frontendQuestionId: 404
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

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
class Solution_404 {
    public static int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            //左节点不为空且左节点的左右子树均为空
            TreeNode tmp = stack.pop();
            if (tmp != null && tmp.left != null && tmp.left.left == null && tmp.left.right == null) {
                sum += tmp.left.val;
            }
            if (tmp.left != null) {
                stack.add(tmp.left);
            }
            if (tmp.right != null) {
                stack.add(tmp.right);
            }
        }
        return sum;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
