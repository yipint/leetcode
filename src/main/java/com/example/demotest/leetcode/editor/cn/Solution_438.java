package com.example.demotest.leetcode.editor.cn;////给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
////
//// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
////
//// 
////
//// 示例 1: 
////
//// 
////输入: s = "cbaebabacd", p = "abc"
////输出: [0,6]
////解释:
////起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
////起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//// 
////
//// 示例 2: 
////
//// 
////输入: s = "abab", p = "ab"
////输出: [0,1,2]
////解释:
////起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
////起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
////起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
//// 
////
//// 
////
//// 提示: 
////
//// 
//// 1 <= s.length, p.length <= 3 * 10⁴ 
//// s 和 p 仅包含小写字母 
//// 
//// Related Topics 哈希表 字符串 滑动窗口 👍 902 👎 0
//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//frontendQuestionId: 438
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a'] ++;
        }

        int slow = 0;
        int fast = 0;
        while (fast < s.length()) {
            if (fast - slow == p.length() - 1) {
                int[] tmp = new int[26];
                for (int i = slow; i <= fast; i++) {
                    tmp[s.charAt(i) - 'a'] ++;
                }

                if (Arrays.equals(count, tmp)) {
                    result.add(slow);
                }
                slow ++;
            }
            fast ++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.printf(findAnagrams("cbaebabacd","abc") + "");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
