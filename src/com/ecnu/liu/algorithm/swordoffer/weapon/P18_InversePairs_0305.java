package com.ecnu.liu.algorithm.swordoffer.weapon;

/**
 * 题目描述
 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 输入描述:
 题目保证输入的数组中没有的相同的数字

 数据范围：

 对于%50的数据,size<=10^4

 对于%75的数据,size<=10^5

 对于%100的数据,size<=2*10^5

 示例1
 输入
 复制
 1,2,3,4,5,6,7,0
 输出
 复制
 7

 https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5?tpId=13&tqId=11188&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P18_InversePairs_0305 {

    /**
     * 时间复杂度: O(n * logn)
     * 空间复杂度: O(n)
     */
    private int cnt = 0;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        mergeSort(nums, 0, nums.length - 1);
        return cnt;
    }

    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + ((hi - lo) >> 1);
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int[] temp = new int[hi - lo + 1];
        int index = 0;
        int p1 = lo, p2 = mid + 1;
        while (p1 <= mid && p2 <= hi) {
            if (nums[p1] <= nums[p2]) {
                temp[index++] = nums[p1++];
            } else {
                // when left part current element p1 is bigger than right part one p2,
                // we can get mid - p1 + 1 inverse pairs in one time.
                // because left part is in order,
                // it means elements which index is bigger than p1 in left part,
                // it's value is also bigger than p1.
                // so all of elements from p1 to mid are bigger than p2,
                // we got mid - p1 + 1 inverse pairs.
                cnt += mid - p1 + 1;
                temp[index++] = nums[p2++];
            }
        }
        while (p1 <= mid) {
            temp[index++] = nums[p1++];
        }
        while (p2 <= hi) {
            temp[index++] = nums[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[lo++] = temp[i];
        }
    }

}
