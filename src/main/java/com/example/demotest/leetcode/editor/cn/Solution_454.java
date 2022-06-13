package com.example.demotest.leetcode.editor.cn;//给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
//
// 
// 0 <= i, j, k, l < n 
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
//输出：2
//解释：
//两个元组如下：
//1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1)
// + 2 = 0
//2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1)
// + 0 = 0
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// n == nums3.length 
// n == nums4.length 
// 1 <= n <= 200 
// -2²⁸ <= nums1[i], nums2[i], nums3[i], nums4[i] <= 2²⁸ 
// 
// Related Topics 数组 哈希表 👍 586 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//frontendQuestionId: 454
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_454 {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //计算前两个数组有多少中可能的和，且每一种有多少中匹配方式
        for (int i=0; i<nums1.length; i++) {
            for (int j = 0; j< nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i=0; i< nums3.length; i++) {
            for (int j=0; j< nums4.length; j++) {
                int sum = nums3[i] + nums4[j];
                if (map.containsKey(0 - sum)) {
                    result += map.get(0 -sum);
                    set.add(sum);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num1  = new int[] {1,2};
        int[] num2  = new int[] {-1,-2};
        int[] num3  = new int[] {-1, 2};
        int[] num4 = new int[] {0,2};
        System.out.printf("" + fourSumCount(num1, num2,num3,num4));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
