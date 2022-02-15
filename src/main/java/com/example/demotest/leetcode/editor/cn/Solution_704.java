package com.example.demotest.leetcode.editor.cn;//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// Related Topics 数组 二分查找 👍 628 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_704 {
    public static int search(int[] nums, int target) {
        //奇数偶数都适用
        //递归
        //return find(nums, 0, nums.length - 1, target);
        //非递归
        if (nums == null || nums.length == 0)  {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int find(int[] nums, int begin, int end, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

//        if (end - begin == 1) {
//            if (nums[begin] == target) {
//                return begin;
//            } else if (nums[end] == target) {
//                return end;
//            } else {
//                return -1;
//            }
//        }
        if (end - begin < 1) {
            return nums[begin] == target ? begin : -1;
        }
        if (target > nums[begin + (end - begin) / 2]) {
            return find(nums, begin + (end - begin) / 2 + 1, end, target);
        } else if (target < nums[begin + (end - begin) / 2]) {
            return find(nums, begin, begin + (end - begin) / 2 - 1, target);
        } else {
            return begin + (end - begin) / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        System.out.printf(search(nums, 2) + "");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
