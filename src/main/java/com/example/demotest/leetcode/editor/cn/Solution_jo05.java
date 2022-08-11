package com.example.demotest.leetcode.editor.cn;//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 297 👎 0

import java.util.Arrays;

//frontendQuestionId: 剑指 Offer 05
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_jo05 {
    public static String replaceSpace(String s) {
        int count = 0;
        for (int i =0; i< s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count ++;
            }
        }
        char[] target  = Arrays.copyOf(s.toCharArray(), s.length() + count * 2);;
        int left = s.length() - 1;
        int index = target.length - 1;
        while (left >= 0) {
            if (target[left] == ' ') {
                target[index] = '0';
                target[--index] = '2';
                target[--index] = '%';
            } else {
                target[index] = target[left];
            }
            index --;
            left --;
        }
        return new String(target);
    }

    public static void main(String[] args) {
        System.out.printf("" + replaceSpace("we are happy"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
