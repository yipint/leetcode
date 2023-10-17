package com.example.demotest.leetcode.editor.cn;//给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
//
// 有效 二叉搜索树定义如下： 
//
// 
// 节点的左子树只包含 小于 当前节点的数。 
// 节点的右子树只包含 大于 当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [2,1,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [5,1,4,null,null,3,6]
//输出：false
//解释：根节点的值是 5 ，但是右子节点的值是 4 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在[1, 10⁴] 内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2188 👎 0

//frontendQuestionId: 98
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
class Solution_98 {
    public boolean isValidBST(TreeNode root) {
       if (root == null) {
           return false;
       }

       List<Integer> tmp = new ArrayList<>();
       mid(root, tmp);
       return isSort(tmp);
    }

    public void mid(TreeNode root, List<Integer> tmp) {
        if (root == null) {
            return;
        }
        mid(root.left, tmp);
        tmp.add(root.val);
        mid(root.right, tmp);
    }

    public boolean isSort(List<Integer> data) {
        for (int i = 0; i < data.size(); i ++) {
            if (i >= 1 && data.get(i) <= data.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
