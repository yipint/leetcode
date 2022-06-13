package com.example.demotest.leetcode.editor.cn;

import java.util.Collections;
import java.util.List;

/**
 * @author tianyipin
 * @desc
 * @since 2022/4/24
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }



    public static ListNode create(List<Integer> input) {
        ListNode cur = null;
        for (int i = input.size() - 1; i >= 0; i--) {
            if (cur == null) {
                cur = new ListNode(input.get(i));
            } else {
                cur =  new ListNode(input.get(i), cur);
            }
        }
        return cur;
    }


}
