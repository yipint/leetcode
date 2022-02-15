package com.example.demotest.leetcode.editor.cn;//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1444 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int left = 0;
        int right = nums.length - 1;
        int begin = -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                begin = mid;
                break;
            }
        }

        if (begin != -1)  {
            //leftIndex为左边界
            //rightIndex为右边界
            int leftIndex = begin;
            int rightIndex = begin;
            while (leftIndex >= 0 && nums[leftIndex] == nums[begin]) {
                leftIndex --;
            }
            while (rightIndex <= nums.length - 1 && nums[rightIndex] == nums[begin]) {
                rightIndex ++;
            }

            result = new int[] {leftIndex + 1, Math.max(0, rightIndex - 1)};
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new int[2];
        result = searchRange(new int[]{1,0}, 1);
        System.out.printf(result[0] + " " + result[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
