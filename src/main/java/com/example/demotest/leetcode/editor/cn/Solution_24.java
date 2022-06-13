package com.example.demotest.leetcode.editor.cn;
//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 👍 1362 👎 0

//frontendQuestionId: 24
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution_24 {
    public static ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode dummy = new ListNode(-1, head);
        ListNode result = null;
        while (cur != null && cur.next != null && cur.next.next != null) {
            ListNode tmp = cur.next;
            //3
            ListNode next = cur.next.next;
            //1->3
            cur.next = next;
            //2->1
            tmp.next = cur;
            if (result == null) {
                result = new ListNode(-1, tmp);
            }
            cur = cur.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode test = ListNode.create(Arrays.asList(1,2,3,4,5,6,7,8));
        ListNode result = swapPairs(test);
        System.out.printf(result + "");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
