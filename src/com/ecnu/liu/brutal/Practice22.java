package com.ecnu.liu.brutal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-23
 * @modified By:
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Practice22 {

    /**
     * 右括号不能大于左括号数就是有效的
     */
    public List<String> generateParenthesis (int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, "", n, 0, 0);
        return result;
    }

    private void backtracking (List<String> result, String s, int n, int l, int r) {
        if (s.length() == 2 * n) {
            result.add(s);
            return;
        }

        //放左括号
        if (l < n) {
            backtracking(result, s + "(", n, l + 1, r);
        }
        //放右括号
        if (r < l) {
            backtracking(result, s + ")", n, l, r + 1);
        }
    }

}
