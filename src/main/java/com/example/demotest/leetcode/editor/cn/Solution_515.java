package com.example.demotest.leetcode.editor.cn;//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 259 👎 0

//frontendQuestionId: 515
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
class Solution_515 {
    public static List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        queue.offer(root);
        result.add(root.val);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int max = Integer.MIN_VALUE;
            boolean hasValue = false;
            while (len > 0) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    hasValue = true;
                    queue.offer(tmp.left);
                    if (tmp.left.val > max) {
                        max = tmp.left.val;
                    }
                }
                if (tmp.right != null) {
                    hasValue = true;
                    queue.offer(tmp.right);
                    if (tmp.right.val > max) {
                        max = tmp.right.val;
                    }
                }
                len --;
            }
            if (hasValue) {
                result.add(max);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        //System.out.printf(largestValues(TestData.constructTree()).toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
