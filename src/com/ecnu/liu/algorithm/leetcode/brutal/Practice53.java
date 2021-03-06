package com.ecnu.liu.algorithm.leetcode.brutal;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal
 * @date: Created in 2020-03-09
 * @modified By:
 *
 *
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice53 {

    /**
     * dp[i]表示到i为止最大的值
     * dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
     * @param nums
     * @return
     */
    public int maxSubArray (int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max,dp[i]);
        }
        //使用max的原因是 只能判断每次到i为止dp[i]的最大值，但是各个dp值之间的值也要比较
        //因为可能nums[i]为负数，dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);无论怎样都可能会比dp[i-1]要小
        return max;
    }
}