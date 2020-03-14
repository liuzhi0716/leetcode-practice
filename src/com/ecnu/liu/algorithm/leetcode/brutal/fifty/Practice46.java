package com.ecnu.liu.algorithm.leetcode.brutal.fifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal.fifty
 * @date: Created in 2020/3/14
 * @modified By:
 * 46. 全排列
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Practice46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backTrack(lists, numList, 0);
        return lists;
    }


    private static void backTrack (List<List<Integer>> lists, List<Integer> numList, int now) {
        if (now == numList.size()) {
            // boxed 转换为对象流 (类似装箱)
            lists.add(new ArrayList<>(numList));
            return;
        }
        for (int i = now; i < numList.size(); i++) {
            Collections.swap(numList, now, i);
            //注意后面是now + 1,不是i+1。 如果是i+1那么这个值是一直在变的,如果是now+1这个值不会因为i变化而变化,为i+1会少几种
            backTrack(lists, new ArrayList<>(numList), now + 1);
            Collections.swap(numList, now, i);
        }
    }

    public static void main (String[] args) {
        permute(new int[]{1,2,3});
    }

}
