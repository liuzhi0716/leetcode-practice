package com.ecnu.liu.algorithm.leetcode.brutal;

import com.ecnu.liu.algorithm.struct.ListNode;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-20
 * @modified By:
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode minHead, maxHead;
        if (l1.val < l2.val) {
            minHead = l1;
            maxHead = l2;
        } else {
            minHead = l2;
            maxHead = l1;
        }
        //第一步就要换位好,防止maxHead节点大于minHead第一个但是小于第二个，就进不去循环了
        //每次比较需要将min与min.next与max指向节点的值比较。同时max所指向节点不会小于min
        //如果比min.next值还要大，min就往后退
        //如果小于或者等于min.next值，则要把max插入了
        ListNode result = minHead;
        while (maxHead != null && minHead.next != null) {
            if (minHead.next.val < maxHead.val) {
                minHead = minHead.next;
            } else {
                ListNode tempMax = maxHead;
                ListNode tempMin = minHead.next;
                maxHead = maxHead.next;
                minHead.next = tempMax;
                tempMax.next = tempMin;
                minHead = minHead.next;
            }
        }//while
        if (minHead.next == null) {
            minHead.next = maxHead;
        }
        return result;
    }
}
