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
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 312 👎 0

//frontendQuestionId: 515
//leetcode submit region begin(Prohibit modification and deletion)

import org.springframework.util.CollectionUtils;

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
class Solution_515bk {
    public static List<Integer> largestValues(TreeNode root) {
        //深度优先
        List<List<Integer>> result = new ArrayList<>();
        result = widthFirst(root);
        List<Integer> max = new ArrayList<>();
        if (!CollectionUtils.isEmpty(result)) {
            for (List<Integer> list : result) {
                if (!CollectionUtils.isEmpty(list)) {
                    max.add(Collections.max(list));
                }
            }
        }
        return max;
    }

    private static void deepFirst(TreeNode root, List<List<Integer>> result, int deep) {
        if (root == null) {
            return;
        }
        deep ++;
        List<Integer> current = new ArrayList<>();
        result.add(current);
        result.get(deep - 1).add(root.val);
        //遍历左子树
        deepFirst(root.left, result, deep);
        //遍历右子树
        deepFirst(root.right, result, deep);
    }

    private static List<List<Integer>> widthFirst(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> current = new ArrayList<>();
            int len = queue.size();
            while (len > 0) {
                TreeNode tmp = queue.poll();
                if (tmp == null) {
                    continue;
                }
                current.add(tmp.val);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
                len --;
            }
            list.add(current);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode testTree = TestData.constructTree();
        List<Integer> result = largestValues(testTree);
        System.out.printf("" + result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
