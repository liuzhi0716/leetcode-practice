package com.ecnu.liu.algorithm.leetcode.weapon.P1_50;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
  示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:

 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/reverse-integer
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P7_IntegerReverse {

    /**
     * 首先利用字符串反转，然后字符串转整形
     * @param x
     * @return
     */
    public int reverse1(int x) {
        String str = new StringBuffer(String.valueOf(Math.abs(x))).reverse().toString();
        str = x > 0 ? str : "-" + str;
        try {
            return Integer.valueOf(str);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 利用长整型存储反转结果，然后跟整形最大和最小值比较
     * 反转方式：取余取整
      */

}
