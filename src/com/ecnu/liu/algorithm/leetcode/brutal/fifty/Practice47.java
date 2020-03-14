package com.ecnu.liu.algorithm.leetcode.brutal.fifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal.fifty
 * @date: Created in 2020/3/14
 * @modified By:
 * 47. 全排列 II
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        backTrack(lists, numList, 0);
        return lists;
    }

    private void backTrack (List<List<Integer>> lists, List<Integer> numList, int now) {
        if (now == numList.size()) {
            // boxed 转换为对象流 (类似装箱)
            lists.add(new ArrayList<>(numList));
            return;
        }
        for (int i = now; i < numList.size(); i++) {
            if (isRepeat(numList, now, i)) {
                continue;
            }
            Collections.swap(numList, now, i);
            if (i > now && numList.get(i).compareTo(numList.get(now)) == 0) {
                continue;
            }
            //注意后面是now + 1,不是i+1。 如果是i+1那么这个值是一直在变的,如果是now+1这个值不会因为i变化而变化,为i+1会少几种
            backTrack(lists, new ArrayList<>(numList), now + 1);
            Collections.swap(numList, now, i);
        }
    }
    //参考46官方题解，只需要添加一句判断当前结点是否在前面重复出现过便可以了
    private boolean isRepeat(List<Integer> nums, int first, int i1){
        int temp = nums.get(i1);
        for (int i=first; i<i1; i++){
            if (nums.get(i) == temp){
                return true;
            }
        }
        return false;
    }

//    作者：cllh1999
//    链接：https://leetcode-cn.com/problems/permutations-ii/solution/gai-jin-46guan-fang-ti-jie-qu-zhong-fu-by-cllh1999/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
