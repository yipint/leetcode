package com.example.demotest.leetcode.editor.cn;//给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: [1,2,3,null,5,null,4]
//输出: [1,3,4]
// 
//
// 示例 2: 
//
// 
//输入: [1,null,3]
//输出: [1,3]
// 
//
// 示例 3: 
//
// 
//输入: []
//输出: []
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,100] 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 719 👎 0

//frontendQuestionId: 199
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
class Solution_199 {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result  = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int len = queue.size();
            List<Integer> items = new ArrayList<>();
            while (len > 0) {
                TreeNode tmp = queue.poll();
                items.add(tmp.val);
                if (tmp.left  != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }

                len --;
            }
            result.add(items.get(items.size() - 1));
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        left.left = new TreeNode(4);
        left.right = new TreeNode(5);

        TreeNode right = new TreeNode(3);
        right.left = new TreeNode(6);
        right.right = new TreeNode(7);

        TreeNode root = new TreeNode(1);
        root.left = left;
        root.right = right;

        System.out.printf(rightSideView(root).toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
