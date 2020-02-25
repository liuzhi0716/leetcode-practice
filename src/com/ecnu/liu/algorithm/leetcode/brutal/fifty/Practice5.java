package com.ecnu.liu.algorithm.leetcode.brutal.fifty;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-01-30
 * @modified By:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Practice5 {

    /**
     * 参考思路：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
     * <p>
     * dp[i][j]表示从第i位置到第j位置是否是回文
     * dp[i][j] = dp[i+1][j-1] && s.chat(i) == s.chat(j)
     *
     *
     * 当i==j时, 单个字符, 是回文串. d[i][j]=1;
     *
     * 当i+1==j时, 两个字符. 此时, s[i]==s[j]时, d[i][j]=1;
     *
     * 其它, 当s[i]==s[j] 且 s[i+1,…,j-1]是回文串时, d[i][j]=1;
     *
     * 关键，千万是内循环，不要fori包forj
     * <p>
     * 边界条件，即 i+1位置与j-1不能构成区间  可以用这个，这个只能判定右边比左边大的极限 i+1 < j-1 --> j-i > 2
     * <p>
     *
     * 如果要用 边界条件是：表达式 [i + 1, j - 1] 不构成区间，即长度严格小于 2，即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3。
     * 那就是取反的情况，可以对思路的代码，刚好相反
     */
    public static String longestPalindrome (String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        boolean dp[][] = new boolean[len][len];
        // 初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int beginIndex = 0;
            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    if (s.charAt(i) == s.charAt(j)) {
                    if (j - i > 2) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = true;
                    }
                } else {
                    dp[i][j] = false;
                }
                if (dp[i][j]) {//如果是true，可能要更新最长
                    if (maxLen < j - i + 1) {
                        maxLen = j - i + 1;
                        beginIndex = i;
                    }
                }
            }
        }//fori
        //substring只取[i,j)
        return s.substring(beginIndex, beginIndex + maxLen);
    }

    public static void main (String[] args) {
        longestPalindrome("abcda");
    }
}
