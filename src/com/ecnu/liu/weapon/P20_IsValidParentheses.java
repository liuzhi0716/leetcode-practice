package com.ecnu.liu.weapon;

import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。

 示例 1:

 输入: "()"
 输出: true
 示例 2:

 输入: "()[]{}"
 输出: true
 示例 3:

 输入: "(]"
 输出: false
 示例 4:

 输入: "([)]"
 输出: false
 示例 5:

 输入: "{[]}"
 输出: true

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-parentheses
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P20_IsValidParentheses {

    /**
     * 使用栈的特性，先进后出
     * LinkedList是双向链表，可作为栈也可以作为队列
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (cur== '(' || cur == '{' || cur == '[') {
                list.addLast(cur);
            } else {
                if (list.size() == 0) return false;
                char ch = list.getLast();
                if ((ch == '(' && cur != ')') || (ch == '[' && cur != ']') || (ch == '{' && cur != '}')) return false;
                else list.removeLast();
            }
        }
        if (list.size() != 0) return false;
        else return true;
    }

}
