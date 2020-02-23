package com.ecnu.liu.algorithm.leetcode.weapon;

import com.ecnu.liu.algorithm.struct.ListNode;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。

 进阶：

 你能尝试使用一趟扫描实现吗？

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P19_RemoveNthFromEnd_0217 {

    /**
     * 两趟扫描
     * 时间复杂度:O(n)
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode ret = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        head = ret;
        int idx = len - n;
        len = 0;
        if (idx == 0) return ret.next;
        while (head != null) {
            len++;
            if (idx == len) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
        return ret;
    }

    /**
     * 一趟扫描
     */
}
