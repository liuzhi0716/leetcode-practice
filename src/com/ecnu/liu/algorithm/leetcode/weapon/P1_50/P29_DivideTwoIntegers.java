package com.ecnu.liu.algorithm.leetcode.weapon.P1_50;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

 返回被除数 dividend 除以除数 divisor 得到的商。

 示例 1:

 输入: dividend = 10, divisor = 3
 输出: 3
 示例 2:

 输入: dividend = 7, divisor = -3
 输出: -2
 说明:

 被除数和除数均为 32 位有符号整数。
 除数不为 0。
 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/divide-two-integers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P29_DivideTwoIntegers {

    /**
     * 减法模式做除法
     * 加速方式：利用减数倍增来加速
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide1(int dividend, int divisor) {
        boolean flag = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) ? false : true;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == Integer.MIN_VALUE) return 1;
        if (divisor == Integer.MIN_VALUE) return 0;

        int i = 0;
        divisor = Math.abs(divisor);
        if (dividend == Integer.MIN_VALUE) {
            i = 1;
            dividend = dividend + divisor;
        }
        dividend = Math.abs(dividend);

        if (dividend < divisor) return flag ? i : -i;

        i = i + div(dividend, divisor);

        return flag ? i : -i;
    }

    public int div(long l, long r) {
        long r1 = r;
        if (l < r) return 0;
        if (l < r + r) return 1;
        int count = 1;
        while (l >= r + r) {
            count = count + count;
            r = r + r;
        }
        return count + div(l - r, r1);
    }

}
