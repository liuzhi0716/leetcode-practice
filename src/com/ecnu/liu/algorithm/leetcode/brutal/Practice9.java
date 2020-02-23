package com.ecnu.liu.algorithm.leetcode.brutal;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-04
 * @modified By:
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class Practice9 {
    /**
     * 进阶
     *
     * 把这个数每次取最低一位，然后加到另一个数上，每次新数*10，旧数/10
     * 1000000001 这个要注意，会超过整数最大上线，所以不能事后乘要事前判定
     */
    static class Solution {
        public boolean isPalindrome(int x) {
            int a = x;
            if (x < 0) {
                return false;
            }
            int reverseNum = 0;
            while (x > 0) {
                reverseNum += x % 10;
                if (x < 10) {
                    //do nothing
                } else {
                    reverseNum *= 10;
                }
                x /= 10;
            }
            if (reverseNum == a) {
                return true;
            }
            return false;
        }
    }

    public static void main (String[] args) {
        Solution s = new Solution();
        s.isPalindrome(1000000001);
    }
}
