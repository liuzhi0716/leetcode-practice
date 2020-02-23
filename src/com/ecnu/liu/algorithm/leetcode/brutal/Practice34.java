package com.ecnu.liu.algorithm.leetcode.brutal;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-22
 * @modified By:
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Practice34 {

    public static int[] searchRange(int[] nums, int target) {
        int rl = -1;
        int rr = -1;
        int l = 0;
        int r = nums.length-1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                if (mid - 1 > 0 && nums[mid -1] != nums[mid]) {
                    rl = mid;
                    break;
                } else {
                    r = mid-1;
                }
            } else if(nums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        l = 0;
        r = nums.length-1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                if (mid + 1 < nums.length-1 && nums[mid + 1] != nums[mid]) {
                    rr = mid;
                    break;
                } else {
                    l = mid+1;
                }
            } else if(nums[mid] > target) {
                r = mid;
            } else {
                l = mid;
            }
        }

        int[] result = new int[2];
        result[0] = rl;
        result[1] = rr;
        return result;
    }

    public static void main (String[] args) {
        searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
}
