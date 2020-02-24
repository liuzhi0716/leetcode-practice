package com.ecnu.liu.algorithm.leetcode.weapon;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

 必须原地修改，只允许使用额外常数空间。

 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/next-permutation
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P31_NextPermutation {

    /**
     * 从右遍历 + 二分搜索 + 反转
     * 时间复杂度：O(n + log(n) + n/2) = O(n)
     * 空间复杂度：O(1)
     * @param nums
     */
    public void nextPermutation1(int[] nums) {
        int i = nums.length-1;
        while (i >= 1) {
            if (nums[i-1] < nums[i]) {
                int temp = nums[i-1];
                int idx = binarySearch(nums, temp, i, nums.length-1);
                nums[i-1] = nums[idx];
                nums[idx] = temp;
                reverse(nums, i, nums.length-1);
                break;
            }
            i--;
        }
        if (i == 0) reverse(nums, i, nums.length-1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 这while条件不能有等于，避免死循环
     * 最后需要判断等于的情况来确定最终的下标
     * @param nums
     * @param val
     * @param left
     * @param right
     * @return
     */
    public int binarySearch(int[] nums, int val, int left, int right) {
        int mid = -1;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > val) left = mid+1;
            else right = mid;
        }
        // 先找到最左边的小于等于val的下标
        if (left == right && nums[right] > val) return right;
        return right-1;
    }

    public static void main(String[] args) {
        P31_NextPermutation p31_nextPermutation = new P31_NextPermutation();
        int[] nums = {1,2,3};
        p31_nextPermutation.nextPermutation1(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println(p31_nextPermutation.binarySearch(nums, 2, 2, 2));
    }
}
