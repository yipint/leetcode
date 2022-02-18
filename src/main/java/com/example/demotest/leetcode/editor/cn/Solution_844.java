package com.example.demotest.leetcode.editor.cn;////给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
////
//// 注意：如果对空文本输入退格字符，文本继续为空。 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：s = "ab#c", t = "ad#c"
////输出：true
////解释：s 和 t 都会变成 "ac"。
//// 
////
//// 示例 2： 
////
//// 
////输入：s = "ab##", t = "c#d#"
////输出：true
////解释：s 和 t 都会变成 ""。
//// 
////
//// 示例 3： 
////
//// 
////输入：s = "a#c", t = "b"
////输出：false
////解释：s 会变成 "c"，但 t 仍然是 "b"。 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= s.length, t.length <= 200 
//// s 和 t 只含有小写字母以及字符 '#' 
//// 
////
//// 
////
//// 进阶： 
////
//// 
//// 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
//// 
//// Related Topics 栈 双指针 字符串 模拟 👍 365 👎 0
//

//844
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_844 {
    //ab##c
    public static boolean backspaceCompare(String s, String t) {
        int sIndex = s.length() - 1;
        int tIndex = t.length() - 1;
        int backNums = 0;
        int backNumt = 0;
        while (true) {
            while (sIndex != -1) {
                if (s.charAt(sIndex) == '#') {
                    backNums ++;
                    sIndex --;
                } else {
                    if (backNums > 0) {
                        sIndex --;
                        backNums --;
                    } else {
                        break;
                    }
                }
            }
            while (tIndex != -1) {
                if (t.charAt(tIndex) == '#') {
                    backNumt ++;
                    tIndex --;
                } else {
                    if (backNumt > 0) {
                        tIndex --;
                        backNumt --;
                    } else {
                        break;
                    }
                }
            }
            if (sIndex == -1 && tIndex == -1) {
                return true;
            } else if (sIndex == -1 || tIndex == -1) {
                return false;
            }

            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex --;
                tIndex --;
                continue;
            } else {
                return false;
            }


        }

    }

    public static void main(String[] args) {
//        String testData = "abc##cd";
//        int realLength = realLength(testData);
//        System.out.println(realLength + "");
        //realLength("b#nzp#o#g".toCharArray());
        System.out.println(backspaceCompare("bxj##tw", "bxj###tw") + "");

    }
}
//leetcode submit region end(Prohibit modification and deletion)
