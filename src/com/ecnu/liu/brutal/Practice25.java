package com.ecnu.liu.brutal;

import com.ecnu.liu.struct.ListNode;

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

    public ListNode reverseKGroup (ListNode head, int k) {
        ListNode result = head;
        while (head != null && k > 1) {
            reverseNode(head, k);
        }
        return null;
    }


    public ListNode reverseNode (ListNode node, int num) {
        ListNode temp = node;
        int index = num;
        //长度不够，就不做操作 如果是5,表示从node开始及后面4个节点如果有一个为空就不做操作
        index -= 1;
        while (index > 0) {
            if (temp == null) {
                return node;
            }
            index--;
            temp = temp.next;
        }

        ListNode tail = temp;
        index = num - 1;
        ListNode afer = tail.next;
        tail.next = null;
        while (index > 0) {
            ListNode temp2 = tail.next;
            tail.next = node;
            node.next = temp2.next;

            if (node.next != null) {
                node = node.next;
            }
            index--;
        }
        node.next = afer;
        return tail;
    }
}
