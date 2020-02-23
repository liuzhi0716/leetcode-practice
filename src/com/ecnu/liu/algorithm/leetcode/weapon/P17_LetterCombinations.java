package com.ecnu.liu.algorithm.leetcode.weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 示例:

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 说明:
 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P17_LetterCombinations {

    private List<String> numbers = new ArrayList<>();
    private List<String> ret = new ArrayList<>(); // 结果

    /**
     * 回溯法
     * 利用数组存储每个下标值对应变化的字符
     * @param digits
     * @return
     */
    public List<String> letterCombinations1(String digits) {
        if (digits.length() == 0) return ret;

        // 初始化数据
        numbers.add("abc");
        numbers.add("def");
        numbers.add("ghi");
        numbers.add("jkl");
        numbers.add("mno");
        numbers.add("pqrs");
        numbers.add("tuv");
        numbers.add("wxyz");

        char[] chs = new char[digits.length()];
        append(0, digits, chs);
        return ret;
    }

    public void append(int i, String digits, char[] chs) {
        if (i == digits.length()) {
            ret.add(String.valueOf(chs));
            return;
        }

        String str = numbers.get(digits.charAt(i)-'2');
        for (int j=0; j<str.length(); j++) {
            chs[i] = str.charAt(j);
            append(i+1, digits, chs);
        }
    }

}
