package com.ecnu.liu.weapon;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/add-two-numbers
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers2 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 时间复杂跟最长的链相关
     * 以l1为最终结果链，每次保留进位值
     * 注意：两条链长度不相等，最终可能需要加节点
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0; // 进位值
        int sum = 0;
        ListNode ret = l1;
        ListNode last = l1;

        while (true) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + temp;
                l1.val = sum % 10;
                temp = sum / 10;
                last = l1;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                sum = l1.val + temp;
                l1.val = sum % 10;
                temp = sum / 10;
                last = l1;
                l1 = l1.next;
            } else if (l2 != null) {
                sum = l2.val + temp;
                l2.val = sum % 10;
                temp = sum / 10;
                last.next = l2;
                last = l2;
                l2 = l2.next;
            } else {
                if (temp > 0) {
                    last.next = new ListNode(temp);
                }
                break;
            }
        }
        return ret;
    }
}
