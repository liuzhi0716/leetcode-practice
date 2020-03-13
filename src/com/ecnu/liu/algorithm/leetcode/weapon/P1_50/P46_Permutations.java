package com.ecnu.liu.algorithm.leetcode.weapon.P1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P46_Permutations {

    List<List<Integer>> ret = new ArrayList<>();

    /**
     * 回溯
     *
     * 时间复杂度：比O(n*n!)快，比O(n!)慢
     * 空间复杂度：O(n!)
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        boolean[] mark = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) mark[i] = false;
        Integer[] temp = new Integer[nums.length];

        run(nums, mark, temp, 0);
        return ret;
    }

    public void run(int[] nums, boolean[] mark, Integer[] temp, int idx) {
        if (idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) list.add(temp[i]);
            ret.add(list);
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (mark[i]) continue;
                mark[i] = true;
                temp[idx] = nums[i];
                run(nums, mark, temp, idx + 1);
                mark[i] = false;
            }
        }
    }
}
