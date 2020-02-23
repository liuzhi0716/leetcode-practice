//package com.ecnu.liu.brutal;
//
///**
// * @author: create by liuxiansen
// * @description: com.ecnu.liu.brutal
// * @date: Created in 2020-02-22
// * @modified By:
// * <p>
// * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
// * <p>
// * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
// * <p>
// * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
// * <p>
// * 你可以假设数组中不存在重复的元素。
// * <p>
// * 你的算法时间复杂度必须是 O(log n) 级别。
// * <p>
// * 示例 1:
// * <p>
// * 输入: nums = [4,5,6,7,0,1,2], target = 0
// * 输出: 4
// * 示例 2:
// * <p>
// * 输入: nums = [4,5,6,7,0,1,2], target = 3
// * 输出: -1
// * <p>
// * 来源：力扣（LeetCode）
// * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
// * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// */
//public class Practice33 {
//
//    public int search (int[] nums, int target) {
//        int l = 0;
//        int r = nums.length - 1;
//        while (l < r) {
//            int m = (l + r) /2;
//            //出现下面两种情况，说明在l-r处有旋转点
//
//            if (nums[m] > nums[r] || nums[m] < nums[l]) {
//                if (target > nums[m]) {
//                    l = m;
//                } else if (target == nums[m]) {
//                    return m;
//                } else {
//                    if(nums[l] > target) {
//                        l = m;
//                    } else if{
//
//                    }
//                }
//            }  else {
//                if (nums[m] == target) {
//                    return m;
//                } else if (nums[m] > target) {
//                    r = m;
//                } else {
//                    l = m;
//                }
//            }
//        }
//    }
//}
