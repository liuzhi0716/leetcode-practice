package com.ecnu.liu.algorithm.leetcode.weapon.P1_50;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

 示例 1:

 输入: "(()"
 输出: 2
 解释: 最长有效括号子串为 "()"
 示例 2:

 输入: ")()())"
 输出: 4
 解释: 最长有效括号子串为 "()()"

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P32_LongestValidParentheses_0223 {

    /**
     * 循环遍历
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public int longestValidParentheses1(String s) {
        char[] chs = s.toCharArray();
        int num = 0;
        int max = 0;

        int left = 0, right = 0;
        while (left < chs.length) {
            while (right < chs.length) {
                if (chs[right] == ')') {
                    if (num == 0) {
                        left = right+1;
                    } else {
                        num--;
                        if (num == 0) {
                            max = Math.max(max, right-left+1);
                        }
                    }
                } else {
                    num++;
                }
                right++;
            }
            left++;
            right = left;
            num = 0;
        }
        return max;
    }

    /**
     * 利用栈存储数组下标
     * 空间换时间
     */


    /**
     * 动态规划
     *
     */

    /**
     * 两趟遍历，先从左到右，再从右到左
     */
}
