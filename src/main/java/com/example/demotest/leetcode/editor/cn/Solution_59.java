//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 688 👎 0
package com.example.demotest.leetcode.editor.cn;
//frontendQuestionId: 59
//leetcode submit region begin(Prohibit modification and deletion)
class Solution_59 {
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[1][1];
        if (n == 1) {
            result[0][0] = 1;
        } else {
            result = new int[n][n];
            //上下左右
            //左闭右开
            int tmp = 1;
            int index = 0;
            int max = n * n;
            while (index < n - 1) {
                for (int i=index; i<n-1-index; i++) {
                    result[index][i] = tmp ++;
                }
                for (int i=index; i<n-1-index; i++) {
                    result[i][n -1 -index] = tmp ++;
                }
                for (int i = n -1 - index; i>index; i--) {
                    result[n-1 - index][i] = tmp ++;
                }
                for (int i=n -1 - index; i>index; i--) {
                    result[i][index] = tmp ++;
                }
                index ++;
            }
            //处理一下奇数中心部分
            if (n % 2 != 0) {
                int mid = n / 2;
                result[mid][mid] = max;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.printf(generateMatrix(4) + "");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
