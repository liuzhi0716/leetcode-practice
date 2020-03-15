package com.ecnu.liu.algorithm.leetcode.brutal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal
 * @date: Created in 2020/3/15
 * @modified By:
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Practice78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            backTrack(result, new ArrayList<>(), 0, nums, i);
        }
        return result;
    }


    public void backTrack(List<List<Integer>> lists, List<Integer> list, int now , int[] nums, int size) {
        if (list.size() == size) {
            lists.add(list);
            return;
        }
        for (int i = now; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(lists, new ArrayList<>(list), i + 1, nums, size);
            list.remove(list.size() - 1);
        }
    }

}
