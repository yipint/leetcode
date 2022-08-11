package com.example.demotest.leetcode.editor.cn;////给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
////
//// 
////
//// 示例 1： 
////
//// 
////输入：root = [3,9,20,null,null,15,7]
////输出：[[15,7],[9,20],[3]]
//// 
////
//// 示例 2： 
////
//// 
////输入：root = [1]
////输出：[[1]]
//// 
////
//// 示例 3： 
////
//// 
////输入：root = []
////输出：[]
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 树中节点数目在范围 [0, 2000] 内 
//// -1000 <= Node.val <= 1000 
//// 
//// Related Topics 树 广度优先搜索 二叉树 👍 590 👎 0
//

//frontendQuestionId: 107
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
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
class Solution_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //常规层次遍历后reverse一下
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> items = new ArrayList<>();
            while (len > 0) {
                TreeNode tmp = queue.poll();
                items.add(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                len --;
            }
            result.add(items);
        }

        Collections.reverse(result);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
