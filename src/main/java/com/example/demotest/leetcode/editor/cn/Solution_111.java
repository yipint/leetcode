package com.example.demotest.leetcode.editor.cn;//给定一个二叉树，找出其最小深度。
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 845 👎 0

//frontendQuestionId: 111
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
class Solution_111 {
    public static int minDepth(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        int deep = 0;
        if (root == null) {
            return deep;
        }
        nodes.offer(root);
        while (!nodes.isEmpty()) {
            int len = nodes.size();
            deep ++;
            while (len > 0) {
                TreeNode cur = nodes.poll();
                if (cur.left != null) {
                    nodes.add(cur.left);
                }
                if (cur.right != null) {
                    nodes.add(cur.right);
                }
                if (cur.left == null && cur.right == null) {
                    return deep;
                }
                len--;
            }
        }
        return deep;
    }

    public static void main(String[] args) {
//        TreeNode test = TestData.constructTree();
//        System.out.printf(minDepth(test) + "");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
