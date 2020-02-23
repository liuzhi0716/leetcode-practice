package com.ecnu.liu.algorithm.leetcode.weapon;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。
 说明:

 所有输入只包含小写字母 a-z 。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-common-prefix
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P14_LongestCommonPrefix_0218 {

    /**
     * 暴力解法：比较每个字符串的相同下标对应的字符
     * 时间复杂度:O(n*min_len(str[i]))
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int idx = 0;
        boolean flag = true;
        while (true) {
            for (int i=0; i<strs.length; i++) {
                if (strs[i].length() <= idx) {
                    flag = false;
                    break;
                }
                if (i > 0 && strs[0].charAt(idx) != strs[i].charAt(idx)) {
                    flag = false;
                    break;
                }
            }
            if (flag) idx++;
            else break;
        }

        if (idx == 0) return "";
        else return strs[0].substring(0, idx);
    }

    /**
     * 分治法，递归
     */
}
