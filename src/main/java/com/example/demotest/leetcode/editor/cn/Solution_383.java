package com.example.demotest.leetcode.editor.cn;//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote 和 magazine 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 👍 341 👎 0

//frontendQuestionId: 383
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_383 {
    public static boolean canConstruct(String ransomNote, String magazine) {

        int len = ransomNote.length();
        int [] count = new int[26];
        for (int i = 0; i< len; i++) {
            count[ransomNote.charAt(i) - 'a'] ++;
        }
        for (int i=0; i<magazine.length(); i++) {
            if (count[magazine.charAt(i) - 'a'] != 0) {
                count[magazine.charAt(i) - 'a'] --;
            }
        }
        for (int i=0 ; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.printf("" + canConstruct("aa", "aab"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
