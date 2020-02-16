package com.ecnu.liu.weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

 注意：答案中不可以包含重复的三元组。

  

 示例：

 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/3sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P15_ThreeSum {

    /**
     * 三数之和拆分为两数之和，再利用有序数组进行首尾向中部搜索（排序+双指针）
     * 时间复杂度：O(n*log(n)) + O(n^2)
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int len = nums.length;

        if (len < 3) return ret;

        for (int i=0; i<len; i++) {
            if (nums[i] > 0) return ret;

            // 去重
            if (i > 0 && nums[i-1] == nums[i]) continue;

            int start = i+1;
            int end = len-1;

            for (int j=start, k=end; j<k; ) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ret.add(list);

                    // 去重
                    while (j<k && nums[j]==nums[j+1]) j++;
                    while (j<k && nums[k-1]==nums[k]) k--;

                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return ret;
    }
}
