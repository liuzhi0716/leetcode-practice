package com.ecnu.liu.algorithm.swordoffer.weapon;

import com.ecnu.liu.algorithm.struct.ListNode;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P26_EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) return null;
        ListNode l1 = pHead.next;
        ListNode l2 = pHead.next.next;
        while (l1 != l2) {
            if (l1 == null || l2 == null) return null;
            l1 = l1.next;
            l2 = l2.next.next;
        }
        l1 = pHead;
        while (l1 != l2) {
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }


}
