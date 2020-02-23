package com.ecnu.liu.brutal;

import com.ecnu.liu.struct.ListNode;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-20
 * @modified By:
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice23 {
    /**
     * 思路1,可以两个合并后，然后把新合并的继续拿下一个合并，等于化解成了21题的两个链表合并
     * 时间复杂度是 两个链表合并的O(n) 与外层的k个,为O(nk)
     */

    /**
     * 思路3可以 k个同时比较，每次都取第一个，把小的吸走
     */

    /**
     * 思路2分治  O(Nlogk) 递归的是可以写成循环
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length ==0) {
            return null;
        }
        int l = 0;
        //两边不能同时是开区间，不然会有重复的
        int r = lists.length;
        return mergeLists(lists, l, r);
    }

    private static ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start + 1 == end || start == end) {
            return lists[start];
        }
        else {
            int mid = (start + end) / 2;
            //两边不能同时是开区间，不然会有重复的,右边为开区间把
            ListNode lNode = mergeLists(lists, start, mid);
            ListNode rNode = mergeLists(lists, mid, end);
            return merge(lNode, rNode);
        }
    }

    private static ListNode merge (ListNode lNode, ListNode rNode) {
        if (lNode == null) {
            return rNode;
        }
        if (rNode == null) {
            return lNode;
        }
        ListNode minNode;
        ListNode maxNode;
        if (lNode.val < rNode.val) {
            minNode = lNode;
            maxNode = rNode;
        } else {
            minNode = rNode;
            maxNode = lNode;
        }
        ListNode head = minNode;
        while (minNode.next != null && maxNode != null) {
            ListNode minNext = minNode.next;
            if (maxNode.val >= minNode.val && maxNode.val < minNext.val) {
                ListNode temp = maxNode.next;
                minNode.next = maxNode;
                maxNode.next = minNext;
                maxNode = temp;
                minNode = minNode.next;
            } else {
                minNode = minNode.next;
            }
        }
        if (minNode.next == null) {
            minNode.next = maxNode;
        }
        return head;
    }

    public static void main (String[] args) {
        ListNode[] array = new ListNode[3];
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(5);
        node11.next = node12;
        node12.next = node13;
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(3);
        ListNode node23 = new ListNode(4);
        node21.next = node22;
        node22.next = node23;
        ListNode node31 = new ListNode(2);
        ListNode node32 = new ListNode(6);
        node31.next = node32;
        array[0] = node11;
        array[1] = node21;
        array[2] = node31;
        mergeKLists(array);
    }
}
