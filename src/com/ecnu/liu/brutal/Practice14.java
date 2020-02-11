package com.ecnu.liu.brutal;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-09
 * @modified By:
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice14 {
    public static String longestCommonPrefix (String[] strs) {
        StringBuffer sb = new StringBuffer();
        int len = 0;
        if (strs.length == 0) {
            return sb.toString();
        }
        String first = strs[0];
        if (first.equals("") || strs.length == 1) {
            return first;
        }
        boolean go = true;
        while (go) {
            for (int i = 1; i < strs.length; i++) {
                if (first.length() <= len || strs[i].length() <= len || strs[i].charAt(len) != first.charAt(len)) {
                    go = false;
                    break;
                }
            }
            if (go) {
                sb.append(first.charAt(len));
                len++;
            }
        }
        return sb.toString();
    }

    /**
     * 方法2，简单明了
     */
    public String longestCommonPrefix2 (String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        char[] str = strs[0].toCharArray();
        //注意是字符数组的长度
        int min = str.length;
        for (int i = 1; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            int j = 0;
            while (j < min && j < s.length && s[j] == str[j]) {
                j++;
            }  //Min已经包含了str.length
            min = min > j ? j : min;
        }
        return strs[0].substring(0, min);


    }

    public static void main (String[] args) {
        String[] array = new String[2];
        array[0] = "c";
        array[1] = "c";
        longestCommonPrefix(array);
    }
}
