package com.ecnu.liu.algorithm.swordoffer.weapon;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。

 https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P9_Stack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public void push(int node) {
        s1.push(node);
        if(s2.empty() || s2.peek() > node) {
            s2.push(node);
        }
    }

    public void pop() {
        if (s1.peek() == s2.peek()) s2.pop();
        s1.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }

}
