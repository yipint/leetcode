package com.example.demotest.leetcode.editor.cn;//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 965 👎 0

//frontendQuestionId: 257
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

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
class Solution_257 {
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();
        travelTree(root, res, paths);
        return res;
    }


    public static void travelTree(TreeNode node, List<String> res, List<Integer> paths) {
        //叶子节点了，拼接一下路径
        paths.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < paths.size(); i++) {
                builder.append(paths.get(i));
                //非结尾部分
                if (i != paths.size() - 1) {
                    builder.append("->");
                }
            }
            res.add(builder.toString());
            return;
        }
        if (node.left != null) {
            travelTree(node.left, res, paths);
            paths.remove(paths.size() - 1);
        }
        if (node.right != null) {
            travelTree(node.right, res, paths);
            paths.remove(paths.size() - 1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
