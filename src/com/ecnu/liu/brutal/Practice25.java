package com.ecnu.liu.brutal;

import com.ecnu.liu.struct.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-22
 * @modified By:
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice25 {

    /**
     * 方法一使用双端队列，满足k就用栈的方法先进后出，不满足就先进先出
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup (ListNode head, int k) {
        if (head == null && k == 1) {
            return head;
        }
        Deque<ListNode> deque = new LinkedList<>();
        ListNode virtual = new ListNode(-1);
        ListNode tail = virtual;
        while (head != null) {
            int num = 0;
            for (int i = 0; i < k; i++) {
                if (head != null) {
                    deque.push(head);
                    head = head.next;
                    num++;
                }
            }
            //满足用栈,不满足用队列出
            if (num == k) {
                for (int i = 0; i < num; i++) {
                    tail.next = deque.pop();
                    tail = tail.next;
                }
            } else {
                for (int i = 0; i < num; i++) {
                    tail.next = deque.pollLast();
                    tail = tail.next;
                }
            }
            tail.next = null;
        }
        return virtual.next;
    }

    /**
     * 方法二 直接for循环 头尾插法，然后拼接好，太复杂 待以后写
     * @param args
     */

    public static void main (String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        reverseKGroup(node1, 3);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        reverseKGroup(node1, 2);
    }

}
