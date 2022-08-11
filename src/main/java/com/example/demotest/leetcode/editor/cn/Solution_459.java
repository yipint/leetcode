package com.example.demotest.leetcode.editor.cn;//给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abab"
//输出: true
//解释: 可由子串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: s = "aba"
//输出: false
// 
//
// 示例 3: 
//
// 
//输入: s = "abcabcabcabc"
//输出: true
//解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
// 
//
// 
//
// 提示： 
//
// 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 👍 711 👎 0

//frontendQuestionId: 459
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_459 {
    public static boolean repeatedSubstringPattern(String s) {
        //暴力解
        char[] tmp = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            //判断一个字符串能否通过一个子串循环遍历
            //abadaf -> ab
            //先通过长度判断下，如果都不能整除就不用进行后续判断了
            if (s.length() % (i + 1) != 0 || s.length() == (i + 1)) {
                continue;
            }
            boolean yes = true;
            while (j < s.length()) {
                if (s.charAt(j) != tmp[j % (i + 1)]) {
                    yes = false;
                    break;
                }
                j++;
            }
            if (yes) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.printf("" + repeatedSubstringPattern("abaababaab"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
