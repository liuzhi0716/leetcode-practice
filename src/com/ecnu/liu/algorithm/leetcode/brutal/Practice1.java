package com.ecnu.liu.algorithm.leetcode.brutal;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-01-27
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice1 {

    /**
     * 时间复杂度O(n2)
     */
    class Solution {
        public int[] twoSum (int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                int k = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (k == nums[j]) {
                        int [] result = new int[2];
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            return null;
        }
    }

    /**
     * 时间复杂度O(n)
     */
    static class Solution1 {
        public int[] twoSum (int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int k = target - nums[i];
                Integer index = map.get(k);
                // index != i 防止是取的自己
                if (index != null && index != i) {
                    int [] result = new int[2];
                    result[0] = i;
                    result[1] = index;
                    return result;
                }
            }
            return null;
        }
    }


}
