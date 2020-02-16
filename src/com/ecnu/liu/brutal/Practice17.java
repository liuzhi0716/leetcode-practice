package com.ecnu.liu.brutal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-12
 * @modified By:
 *
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice17 {

    public List<String> letterCombinations(String digits) {
        return null;
    }



    public static void all(List<String> list, String a1, String a2, int l1, int l2) {
        for (int i = l1; i < a1.length(); i++) {
            for (int j = l2; j < a2.length(); j++) {
                String result = a1.charAt(i) + "" + a2.charAt(j);
                list.add(result);
                all(list, a1, a2, l1+1, l2+1);
            }
        }
    }
}
