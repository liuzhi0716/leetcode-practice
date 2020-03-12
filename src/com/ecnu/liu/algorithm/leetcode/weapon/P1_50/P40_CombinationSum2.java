package com.ecnu.liu.algorithm.leetcode.weapon.P1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P40_CombinationSum2 {

    /**
     * 回溯
     */
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        go(candidates, target, 0, 0);
        return ret;
    }

    public void go(int[] candidates, int target, int sum, int idx) {
        if (sum > target) return; // 剪枝
        if (sum == target) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(list);
            ret.add(temp);
        } else {
            for(int i=idx; i<candidates.length; i++) {

                // 去重
                if (i>idx && candidates[i]==candidates[i-1]) continue;

                sum += candidates[i];
                list.add(candidates[i]);

                go(candidates, target, sum, i+1);

                sum -= candidates[i];
                list.remove(list.size()-1);
            }
        }
    }

}
