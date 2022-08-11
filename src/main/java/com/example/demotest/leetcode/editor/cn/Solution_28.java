package com.example.demotest.leetcode.editor.cn;//实现 strStr() 函数。
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1454 👎 0

import java.util.HashSet;
import java.util.Set;

//frontendQuestionId: 28
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_28 {

    //构建前缀表next[i]
    public static int[] next(String s) {
        //j是前缀末尾
        int j = 0;
        int [] next = new int[s.length()];
        next[0] = 0;
        //i是后缀结尾，因为s.charAt(0)没有后缀,所以从1开始即可
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                //j回溯一位
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            //记录一下当前的最长相同前后缀
            next[i] = j;
        }
        return next;
    }

    //KMP，前缀串解法
    public static int strStr(String haystack, String needle) {
        //首先每次匹配到不符合的，就到之前哪个的开始字符继续匹配
        int srcL = haystack.length();
        int srcT = needle.length();
        if (srcL == 0) {
            return 0;
        }
        int i = 0, j = 0;
        while (i< srcL && j < srcT) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                //回溯到最开始的字符的下一个字符
                i = i - j + 1;
                //从头开始检索匹配
                j = 0;
            }
        }
        if (j == srcT) {
            return i - j;
        } else {
            return -1;
        }

    }









    //暴力解法，每次匹配到首字母相同的，就连续判定单位长度
    //不然就匹配下一个相同字母
    public static int strStr1(String haystack, String needle) {
        //return hay.indexof(need)
        if (haystack.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int left = 0, right = 0;
        int begin = 0;
        Set<Integer> error = new HashSet<>();
        while (right < haystack.length()) {

            if (haystack.charAt(right) != needle.charAt(begin)) {
                right ++;
                left ++;
            } else {
                if (error.contains(left)) {
                    right ++;
                    left ++;
                    continue;
                }
                if (right + needle.length() > haystack.length()) {
                    return -1;
                }
                if (needle.length() == 1) {
                    return left;
                }
                boolean yes = true;
                while (right < left + needle.length() -1) {
                    if (haystack.charAt(++right) != needle.charAt(++begin)) {
                        yes = false;
                        error.add(left);
                        left=right=begin=0;
                        break;
                    }
                }
                if (yes) {
                    return left;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.printf("" + strStr("aasadfda", "df"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
