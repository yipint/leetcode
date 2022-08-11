package com.example.demotest.leetcode.editor.cn;//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 871 👎 0

//frontendQuestionId: 145
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
class Solution_145houxu {

    public void pt(TreeNode treeNode, List<Integer> list) {
        while (treeNode == null) {
            return;
        }
        pt(treeNode.left, list);
        pt(treeNode.right, list);
        list.add(treeNode.val);
    }

//    0.

    public static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            stack.push(root);
            result.add(stack.pop().val);
        }
        while (root != null) {
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
                root = root.right;
                result.add(stack.pop().val);
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                root = stack.pop();
                result.add(root.val);
            }

        }
        Collections.reverse(result);
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

        System.out.printf(postorderTraversal(root).toString());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
