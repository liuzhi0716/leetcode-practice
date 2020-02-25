package com.ecnu.liu.algorithm.leetcode.brutal.fifty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-12
 * @modified By:
 * <p>
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice17 {

    public static List<String> letterCombinations (String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        String[] array = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            array[i] = tran2str(digits.charAt(i) - '0');
        }
        List<String> result = new ArrayList<>();
        all(array, 0, new StringBuilder(), result);
        return result;
    }


    private static void all (String[] array, int start, StringBuilder sb, List<String> list) {
        if (start == array.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < array[start].length(); i++) {
            sb.append(array[start].charAt(i));
            all(array, start + 1, new StringBuilder(sb), list);
            // 撤销操作
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private static String tran2str (int num) {
        switch (num) {
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
            default:
                return "";
        }
    }

    public static void main (String[] args) {
        letterCombinations("");
    }
}
