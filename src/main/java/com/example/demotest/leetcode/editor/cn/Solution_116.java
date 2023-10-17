package com.example.demotest.leetcode.editor.cn;////给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
////
////
////
//// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
////
//// 初始状态下，所有 next 指针都被设置为 NULL。 
////
//// 
////
//// 示例 1： 
////
//// 
////
//// 
////输入：root = [1,2,3,4,5,6,7]
////输出：[1,#,2,3,#,4,5,6,7,#]
////解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点
//由 
////next 指针连接，'#' 标志着每一层的结束。
//// 
////
//// 
////
//// 示例 2: 
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
//// 树中节点的数量在 [0, 2¹² - 1] 范围内 
//// -1000 <= node.val <= 1000 
//// 
////
//// 
////
//// 进阶： 
////
//// 
//// 你只能使用常量级额外空间。 
//// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
//// 
//// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 848 👎 0
//

//frontendQuestionId: 116
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution_116 {
    public static Node connect(Node root) {
//        List<List<Node>> nodes = new ArrayList<>();
//        if (root == null) {
//            return null;
//        }
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            List<Node> list = new ArrayList<>();
//            int len = queue.size();
//            while (len > 0) {
//                Node tmp = queue.poll();
//                if (tmp.left != null) {
//                    list.add(tmp.left);
//                    queue.offer(tmp.left);
//                }
//                if (tmp.right != null) {
//                    list.add(tmp.right);
//                    queue.offer(tmp.right);
//                }
//                len --;
//            }
//            nodes.add(list);
//        }
//        for (List<Node> list: nodes) {
//            for (int i = 0; i < list.size() - 1; i++) {
//                list.get(i).next = list.get(i + 1);
//            }
//        }
//        return root;
        return null;
    }


    public static void main(String[] args) {
//        Node test = TestData.constructNode();
//        Node root = connect(test);
//        System.out.printf(root + "");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
