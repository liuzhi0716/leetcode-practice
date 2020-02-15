package com.ecnu.liu.weapon;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba" 也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb"

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome5_0215 {

    /**
     * 扩展中心
     * 从第二个字符开始，先考虑与之相同的字符，然后左右两边的字符做比较，直到两边的字符不相等为止。
     * 时间复杂度最坏的是O(n^2)，最好的是O(n)
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len == 1) return s;
        if (len == 2) {
            if (s.charAt(0) == s.charAt(1)) return s;
            else return s.substring(0,1);
        }

        String max = "", temp = "";

        for (int i=1; i<len-1; i++) {
            int left = i-1, right = i+1;
            while (left>=0 && s.charAt(i)==s.charAt(left)) left--;
            while (right<len && s.charAt(i)==s.charAt(right)) right++;

            while (left != -1 && right != len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }

            temp = s.substring(left+1, right);
            max = temp.length() > max.length() ? temp : max;
        }

        return max;
    }

    // 动态规划


    // Manacher 算法 + 扩展中心（不需要掌握）


}
