package com.example.demotest.leetcode.editor.cn;//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
// Related Topics 双指针 字符串 👍 306 👎 0

//frontendQuestionId: 541
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_541 {
//    public static String reverseStr(String s, int k) {
//        char[] tmp = s.toCharArray();
//
//        int index = 0;
//        int lastIndex = 0;
//        int remain = s.length() % (2 * k);
//        if (tmp.length <= 2 * k) {
//            if (tmp.length < k) {
//                reverseString(tmp, index, null);
//            } else {
//                reverseString(tmp, index, index + k);
//            }
//            return new String(tmp);
//        }
//        while (index < tmp.length) {
//            if (index - lastIndex == 2 * k) {
//                reverseString(tmp, lastIndex, lastIndex + k);
//                lastIndex = index;
//            }
//            if (index == s.length() - remain) {
//                if (remain < k) {
//                    reverseString(tmp, index, null);
//                } else {
//                    reverseString(tmp, index, index + k);
//                }
//                break;
//            }
//            index ++;
//        }
//        return new String(tmp);
//    }

    public static void reverseString(char[] s, Integer first, Integer last) {
        int left = first == null ? 0 : first;
        int right = last == null ?  s.length - 1 : last - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left ++;
            right --;
        }
    }

    //固定间隔循环可以跨指定间隔效率较高 i+= 2 * k;
    //两数交换使用亦或执行效率更高且节约空间
    public static String reverseStr(String s, int k) {
        char[] tmp = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2*k) {
            int start = i;
            int end = Math.min(s.length() - 1, start + k - 1);
            while (start < end) {
                char ch = tmp[start];
                tmp[start] = tmp[end];
                tmp[end] = ch;
                start ++;
                end --;
            }
        }
        return new String(tmp);
    }

    public static void main(String[] args) {
        System.out.printf("" + reverseStr("abcdefg", 2));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
