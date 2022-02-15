package com.example.demotest.leetcode.editor.cn;//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 884 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution_69 {
    public static int mySqrt(int x) {
        if (0 == x) {
            return 0;
        }
        long left = 1;
        long right = x;
        while (left <= right) {
            long resultX = 0;
            long mid = left + (right - left) / 2;
            if (String.valueOf(mid).length() * 2 > String.valueOf(x).length() + 1) {
                right = mid - 1;
                continue;
            }
            resultX = mid * mid;
            if (x == resultX ) {
                return Long.valueOf(mid).intValue();
            }
            if (resultX > x) {
                right = mid - 1;
            } else {
                resultX = (mid + 1) * (mid + 1);
                if (resultX  > x) {
                    return Long.valueOf(mid).intValue();
                } else {
                    left = mid + 1;
                }
            }
        }

        return Long.valueOf(left).intValue();
    }


    public static void main(String[] args) {
        System.out.printf(mySqrt( 2147395599) + "");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
