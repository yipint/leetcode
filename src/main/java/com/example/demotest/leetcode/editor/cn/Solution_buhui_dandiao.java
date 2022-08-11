package com.example.demotest.leetcode.editor.cn;//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1691 👎 0

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//frontendQuestionId: 239
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_buhui_dandiao {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<Integer>();
        int[] result = new int[nums.length - (k - 1)];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (queue.isEmpty()) {
                queue.addLast(nums[i]);
            } else {
                if (nums[i] > queue.peek() || k==1) {
                    queue.addFirst(nums[i]);
                }
            }

            if (i >= k-1) {
                result[index++] = queue.peek();
                queue.addLast(nums[i]);
                queue.removeLast();
                if (queue.size() == k) {
                    queue.removeLast();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //int[] test = new int[]{1,3,-1,-3,5,3,6,7};
        int[] test = new int[]{7,2,4};
        System.out.printf(Arrays.toString(maxSlidingWindow(test, 2)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
