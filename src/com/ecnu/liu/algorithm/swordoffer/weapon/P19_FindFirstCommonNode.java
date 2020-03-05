package com.ecnu.liu.algorithm.swordoffer.weapon;

import com.ecnu.liu.algorithm.struct.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P19_FindFirstCommonNode {

    /**
     * 双指针法，遍历两次链表
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        int len1 = 0, len2 = 0;
        while(p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while(p2 != null) {
            len2++;
            p2 = p2.next;
        }

        int i = Math.abs(len1 - len2);
        if (len1 > len2) {
            while(i-- > 0) pHead1 = pHead1.next;
        } else if (len1 < len2) {
            while(i-- > 0) pHead2 = pHead2.next;
        }

        while (pHead1 != null && pHead2 != null) {
            if (pHead1 == pHead2) return pHead1;
            else {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return null;
    }

}
