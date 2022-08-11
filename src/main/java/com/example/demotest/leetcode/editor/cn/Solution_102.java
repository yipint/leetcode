package com.example.demotest.leetcode.editor.cn;//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1380 👎 0

//frontendQuestionId: 102
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
class Solution_102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //dfs(root, 0, result);
        bfs(root, result);
        return result;
    }

    public static void dfs(TreeNode root, Integer deep, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        deep ++;
        if (result.size() < deep) {
            List<Integer> item = new ArrayList<>();
            result.add(item);
        }
        result.get(deep - 1).add(root.val);
        dfs(root.left, deep, result);
        dfs(root.right, deep, result);
    }

    public static void bfs(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> itemLis = new ArrayList<>();
            while (len > 0) {
                TreeNode tmp = queue.poll();
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                itemLis.add(tmp.val);
                len --;
            }
            result.add(itemLis);
        }
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

        System.out.printf(levelOrder(root).toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
