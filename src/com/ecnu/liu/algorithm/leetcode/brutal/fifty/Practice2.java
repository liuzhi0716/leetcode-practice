package com.ecnu.liu.algorithm.leetcode.brutal.fifty;

import com.ecnu.liu.algorithm.struct.ListNode;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-01-27
 * @modified By:
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice2 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
            ListNode l3 = new ListNode(0);
            ListNode head = l3;
            int level = 0;
            int len = 0;
            while (l1 != null && l2 != null) {
                int v = l1.val + l2.val + level;
                level = 0;
                if (v >= 10) {
                    v -= 10;
                    level = 1;
                }
                l3.val = v;
                ListNode next = new ListNode(0);
                l3.next = next;
                l3 = l3.next;
                l1 = l1.next;
                l2 = l2.next;
                len++;
            }
            if (l1 == null) {
                while (l2 != null) {
                    int v = l2.val + level;
                    level = 0;
                    if (v >= 10) {
                        v -= 10;
                        level = 1;
                    }
                    l3.val = v;
                    ListNode next = new ListNode(0);
                    l3.next = next;
                    l3 = l3.next;
                    l2 = l2.next;
                    len++;
                }//while
            } else if (l2 == null) {
                while (l1 != null) {
                    int v = l1.val + level;
                    level = 0;
                    if (v >= 10) {
                        v -= 10;
                        level = 1;
                    }
                    l3.val = v;
                    ListNode next = new ListNode(0);
                    l3.next = next;
                    l3 = l3.next;
                    l1 = l1.next;
                    len++;
                }//while
            }

            if (level != 0) {
                l3.val = level;
            }
            //移除首位0,这里长度是len-1，因为头元素就已经占了一位
            ListNode temp = head;
            for (int i = 0; i < len - 1; i++) {
                temp = temp.next;
            }
            if (temp.next != null && temp.next.val == 0) {
                temp.next = null;
            }
            return head;
        }
    }
}
