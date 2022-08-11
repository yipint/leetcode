package com.example.demotest.leetcode.editor.cn;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，
// 判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3338 👎 0

import java.util.Stack;

//frontendQuestionId: 20
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i) == ')' && stack.peek() == '('
                    || s.charAt(i) == ']' && stack.peek() == '['
                    || s.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
            i++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.printf("" + isValid("({[)"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
