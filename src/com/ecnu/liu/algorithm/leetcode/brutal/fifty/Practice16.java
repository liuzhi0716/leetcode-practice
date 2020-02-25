package com.ecnu.liu.algorithm.leetcode.brutal.fifty;

import java.util.Arrays;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-12
 * @modified By:
 * <p>
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice16 {

    public static int threeSumClosest (int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[nums.length - 1];
        //min不要设置在for里面了，不然会被覆盖
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return target;
                } else if(sum > target) {
                    r--;
                    if (Math.abs(min - target) > Math.abs(sum - target)) {
                        min = sum;
                    }
                } else {
                    l++;
                    if (Math.abs(min - target) > Math.abs(sum - target)) {
                        min = sum;
                    }
                }
            }
        }
        //返回这三个数的和,min是三数之和与target的最小差距
        return min;
    }

    public static void main (String[] args) {
        int[] array = new int[]{1, 1, 1, 0};
        threeSumClosest(array, -100);
    }
}
