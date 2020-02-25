package com.ecnu.liu.algorithm.leetcode.brutal.fifty;

import com.ecnu.liu.algorithm.struct.ListNode;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-17
 * @modified By:
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice19 {

    /**
     * 直接用进阶吧，不扫两次了
     * 倒数第n个,去掉第一个首节点，只用走n-1次,不过加了一个虚拟的头节点，则还是走n次
     */

    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode virtual = new ListNode(-1);
        virtual.next = head;

        ListNode now = virtual;
        int len = n;
        while (len > 0 && now != null) {
            now = now.next;
            len--;
        }
        ListNode remove = virtual.next;
        ListNode behindRemove = virtual;
        //注意这里不是now是now.next，可以用测试用例心算
        while (now.next != null) {
            now = now.next;
            remove = remove.next;
            behindRemove = behindRemove.next;
        }
        behindRemove.next = remove.next;
        return virtual.next;
    }
}
