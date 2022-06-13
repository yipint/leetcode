package com.example.demotest.leetcode.editor.cn;//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4855 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//frontendQuestionId: 15
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> integerList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(integerList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        if (nums.length == 0 || integerList.get(0) > 0) {
            return result;
        }
        for (int i=0; i< integerList.size() -2; i++) {
            int left = i + 1;
            int right = integerList.size() - 1;
            while (left < right) {
                if (integerList.get(left) + integerList.get(right) + integerList.get(i) > 0) {
                    right --;
                } else if (integerList.get(left) + integerList.get(right) + integerList.get(i) < 0) {
                    left ++;
                } else {
                    List<Integer> integers = new ArrayList<>();
                    integers.add(integerList.get(i));
                    integers.add(integerList.get(left));
                    integers.add(integerList.get(right));
                    if (!result.contains(integers)) {
                        result.add(integers);
                    }
                    left ++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[] {-1,0,1,2,-1,-4};
        System.out.printf("" + threeSum(test));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
