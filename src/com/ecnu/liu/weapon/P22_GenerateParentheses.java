package com.ecnu.liu.weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

 例如，给出 n = 3，生成结果为：

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/generate-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P22_GenerateParentheses {

    private List<String> ret = new ArrayList<>();

    /**
     * 回溯法
     * 时间复杂度：O(2^(2n))
     * 空间复杂度：O(2n)
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        if (n <= 0) return ret;
        char[] chs = new char[n*2];
        go(0, n, chs, 0, 0);
        return ret;
    }

    public void go(int i, int n, char[] chs, int left, int right) {
        if (i == n*2) {
            ret.add(String.valueOf(chs));
        } else {
            if (left == right) {
                chs[i] = '(';
                go(i+1, n, chs, left+1, right);
            } else if (left == n) {
                chs[i] = ')';
                go(i+1, n, chs, left, right+1);
            } else {
                chs[i] = '(';
                go(i+1, n, chs, left+1, right);
                chs[i] = ')';
                go(i+1, n, chs, left, right+1);
            }
        }
    }

}
