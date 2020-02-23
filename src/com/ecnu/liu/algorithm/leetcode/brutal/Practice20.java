package com.ecnu.liu.algorithm.leetcode.brutal;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-17
 * @modified By:
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice20 {

    /**
     * 用栈就可以了，但是注意健壮性
     *
     */
    public boolean isValid (String s) {
        Deque<Character> deque = new LinkedList();
        char[] array = s.toCharArray();
        if (array.length % 2 != 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(' || array[i] == '[' || array[i] == '{') {
                deque.push(array[i]);
            } else {
                if (deque.size() == 0) {
                    return false;
                }
                char now = deque.pop();
                boolean match = (array[i] == ')' && now == '(') || (array[i] == ']' && now == '[') || (array[i] == '}' && now == '{');
                if (!match) {
                    return false;
                }
            }
        }
        return deque.size() == 0;
    }
}
