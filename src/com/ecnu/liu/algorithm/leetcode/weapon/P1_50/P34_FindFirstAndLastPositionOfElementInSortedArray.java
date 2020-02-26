package com.ecnu.liu.algorithm.leetcode.weapon.P1_50;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

 你的算法时间复杂度必须是 O(log n) 级别。

 如果数组中不存在目标值，返回 [-1, -1]。

 示例 1:

 输入: nums = [5,7,7,8,8,10], target = 8
 输出: [3,4]
 示例 2:

 输入: nums = [5,7,7,8,8,10], target = 6
 输出: [-1,-1]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P34_FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 线性扫描
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange1(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] < target) continue;
            if (nums[i] > target) break;

            if (nums[i] == target) {
                if (ret[0] == -1) ret[0] = i;
                ret[1] = i;
            }
        }
        return ret;
    }

    /**
     * 二分查找
     * 时间复杂度：O(log(n))
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};

        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) break;
            else if (nums[mid] > target) right = mid-1;
            else left = mid + 1;
        }
        if (left <= right) {
            left = mid;
            right = mid;
            while (left >= 0 && nums[left] == target) ret[0] = left--;
            while (right < nums.length && nums[right] == target) ret[1] = right++;
        }

        return ret;
    }
}
