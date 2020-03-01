package com.ecnu.liu.algorithm.swordoffer.weapon;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P10_VerifySquenceOfBST {

    /**
     * 根据二叉排序树后序遍历的规则，每一次找到头结点的下标
     *
     * 时间复杂度：O(log(n)*n)
     * 空间复杂度：O(1)
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        return check(sequence, 0, sequence.length-1);
    }

    public boolean check(int[] sequence, int left, int right) {
        if (sequence.length == 0) return false;
        if (right - left <= 1) return true;

        int mid = sequence[right];
        int i = left;
        for (; i<right; i++) {
            if (sequence[i] > mid) {
                for (int j=i+1; j<right; j++){
                    if (sequence[j] < mid) return false;
                }
            }
        }

        return check(sequence, left, i-1) && check(sequence, i, right-1);
    }

}
