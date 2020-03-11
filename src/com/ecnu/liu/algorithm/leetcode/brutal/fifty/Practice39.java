package com.ecnu.liu.algorithm.leetcode.brutal.fifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal.fifty
 * @date: Created in 2020-03-11
 * @modified By:
 * 39. 组合总和
 * <p>
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
public class Practice39 {


    public static List<List<Integer>> combinationSum (int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        addList(result, new ArrayList<>(), 0, candidates, target);
        return result;
    }


    private static void addList (List<List<Integer>> lists, List<Integer> now, int num, int[] candidates, int target) {
        if (0 > target) {
            return;
        } else if (0 == target) {
            lists.add(now);
            return;
        }
        for (int i = num; i < candidates.length; i++) {
            if(target < candidates[i]) break;
            now.add(candidates[i]);
            addList(lists, new ArrayList<>(now), i, candidates, target - candidates[i]);
            now.remove(now.size() - 1);
        }
    }

    public static void main (String[] args) {
        int[] array = new int[]{2, 3, 6, 7};
        combinationSum(array, 7);
    }
}
