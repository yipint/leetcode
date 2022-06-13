package com.example.demotest.leetcode.editor.cn;//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 1272 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//frontendQuestionId: 18
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result  = new ArrayList<>();
        List<Integer> list = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());
        if (nums.length < 4 || list.get(0) > target && list.get(0) > 0 && target > 0) {
            return result;
        }
        for (int i = 0; i < list.size() - 2; i++) {
            for (int j = i + 1; j < list.size() - 1; j ++) {
                int left = 0;
                int right = list.size() - 1;
                while (left < right) {
                    if (left == i || left == j) {
                        left ++;
                        continue;
                    }
                    if (right == j || right == i) {
                        right --;
                        continue;
                    }
                    int sum = list.get(i) + list.get(j) + list.get(left) + list.get(right);
                    if (sum > target) {
                        right --;
                    } else if (sum < target) {
                        left ++;
                    } else {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(list.get(i));
                        tmp.add(list.get(j));
                        tmp.add(list.get(left));
                        tmp.add(list.get(right));
                        tmp = tmp.stream().sorted().collect(Collectors.toList());
                        if (!result.contains(tmp)) {
                            result.add(tmp);
                        }
                        left++;right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[] {5,5,3,5,1,-5,1,-2};
        System.out.printf("" + fourSum(test, 4));
       // -3 -1 0 4

    }
}
//leetcode submit region end(Prohibit modification and deletion)
