package com.ecnu.liu.algorithm.leetcode.weapon.P1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P39_CombinationSum {

    /**
     * 回溯
     *
     * 时间复杂度：
     * 空间复杂度：O(递归深度)
     */
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        go(candidates, target, 0, 0);
        return ret;
    }

    public void go(int[] candidates, int target, int sum, int idx) {
        if (sum > target) return;
        if (sum == target) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            ret.add(temp);
        } else {
            for(int i=idx; i<candidates.length; i++) {
                sum += candidates[i];
                list.add(candidates[i]);

                go(candidates, target, sum, i);

                sum -= candidates[i];
                list.remove(list.size()-1);
            }
        }
    }

}
