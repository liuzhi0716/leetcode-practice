package com.ecnu.liu.algorithm.leetcode.weapon.P1_50;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/3sum-closest
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P16_ThreeSumClosest_0219 {

    /**
     * 双指针法
     * 利用三数之和的原理，每次比较两数的绝对值大小，取绝对值小的。
     * 时间复杂度：O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int left=0, right=nums.length-1;
        int sum = Integer.MAX_VALUE, temp = 0;
        for (int i=0; i<nums.length-2; i++) {
            temp = target-nums[i];
            left = i+1;
            right = nums.length-1;
            while (left < right) {
                int cur = temp - (nums[left] + nums[right]);
                if (Math.abs(sum) > Math.abs(cur)) {
                    sum = cur;
                }
                if (cur > 0) left++;
                else right--;
                if (sum == 0) break;
            }
            if (sum == 0) break;
        }
        return target-sum;
    }

}
