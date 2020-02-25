package com.ecnu.liu.algorithm.leetcode.brutal.fifty;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-22
 * @modified By:
 * <p>
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice29 {

    public static int divide (int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        if(divisor == -1){
            if(dividend>Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
            return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
        }

        boolean beforeZero;
        if (dividend > 0 && divisor > 0) {
            beforeZero = true;
        } else if (dividend < 0 && divisor < 0) {
            beforeZero = true;
        } else {
            beforeZero = false;
        }
        //对一种情况特殊处理
        //这样一定会溢出
        if (dividend == Integer.MIN_VALUE && !beforeZero) {
            return Integer.MAX_VALUE;
        }

        if (dividend < 0) {
            dividend = -dividend;
//            //如果溢出则赋值是不会成功的
//            if (dividend < 0) {
//                return Integer.MIN_VALUE;
//            }
//            if (dividend == Integer.MAX_VALUE) {
//                return Integer.MIN_VALUE;
//            }
        }
        if (divisor < 0) {
            divisor = -divisor;
        }
        int result = 0;
        while (dividend >= divisor) {
            dividend -= divisor;
            result++;
        }
        if (beforeZero) {
            return result;
        } else {
            return -result;
        }
    }

    public static void main (String[] args) {
        divide(-21, -1);
    }
}
