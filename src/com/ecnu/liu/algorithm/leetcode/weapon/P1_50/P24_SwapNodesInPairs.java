package com.ecnu.liu.algorithm.leetcode.weapon.P1_50;

import com.ecnu.liu.algorithm.struct.ListNode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

  

 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P24_SwapNodesInPairs {

    /**
     * 双指针法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode ret = head.next;
        ListNode r = head.next.next;
        ret.next = head;
        ListNode l = head;
        l.next = null;

        while (r != null && r.next != null) {
            l.next = r.next;
            r.next = r.next.next;
            l.next.next = r;
            l = r;
            r = r.next;
            l.next = null;
        }

        if (r != null) l.next = r;

        return ret;
    }
}
