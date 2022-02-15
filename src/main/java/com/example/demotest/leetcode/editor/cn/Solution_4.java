package com.example.demotest.leetcode.editor.cn;//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 4961 👎 0


import java.util.*;
import java.util.stream.Collectors;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] dest = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, dest, 0, nums1.length);
        System.arraycopy(nums2, 0, dest, nums1.length, nums2.length);
        List<Integer> list = Arrays.stream(dest).boxed().collect(Collectors.toList());
        if (list.stream().distinct().collect(Collectors.toList()).size() == 1) {
            return list.get(0);
        }
        int mid = list.size() % 2 == 0 ? list.size() / 2 - 1 : (list.size() - 1) / 2;
        int begin = 0;
        int end = list.size()  - 1;
        int num = partition(list, begin, end);
        List<Integer> result = new ArrayList<>();
        while (true) {
            //如果是奇数之算出中间1个哨兵即可
            if (list.size() % 2 != 0) {
                if (num == mid) {
                    return list.get(mid);
                }
                //如果是偶数需要算出中间两个哨兵
            } else {
                if (num == mid) {
                    result.add(list.get(num));
                }
                if (result.size() == 2) {
                    return (list.get(mid) + list.get(mid + 1)) / 2.0;
                }
            }
            if (num < mid) {
                begin = num + 1;
            } else if (num > mid) {
                end = num - 1;
            }
            num = partition(list, begin, end);
        }
    }

    public static int partition(List<Integer> input, int begin, int end) {
        int i = begin;
        int j = end;
        int base = input.get(i);
        while (i < j) {
            while (input.get(j) >= base && j > i) {
                j --;
            }
            while (input.get(i) <=
                    base && i < j) {
                i ++;
            }

            if (i < j && input.get(i) > input.get(j)) {
                swap(input, i, j);
            }
        }
        if (input.size() > 2) {
            swap(input, begin, i);
        }
        return i;
    }

    public static void swap(List<Integer> list, int front, int back) {
        int tmp = list.get(back);
        list.set(back, list.get(front));
        list.set(front, tmp);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6, 1, 2, 7, 9, 3, 4, 5, 10, 8);
        int[] num1 = new int[]{1,2,3};
        int[] num2 = new int[]{1,2,2};
        findMedianSortedArrays(num1, num2);
        //System.out.printf(partition(list, 0, list.size() - 1) + "");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
