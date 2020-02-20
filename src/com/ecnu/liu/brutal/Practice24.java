package com.ecnu.liu.brutal;

import com.ecnu.liu.struct.ListNode;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-20
 * @modified By:
 */
public class Practice24 {

    public ListNode swapPairs(ListNode head) {
        ListNode virtual = new ListNode(-1);
        virtual.next = head;
        ListNode now = virtual;
        while (now.next != null && now.next.next != null) {
            ListNode temp = now.next;
            now.next = now.next.next;
            temp.next = now.next.next;
            now.next.next = temp;
            now = now.next;
            now = now.next;
        }
        return virtual.next;
    }
}
