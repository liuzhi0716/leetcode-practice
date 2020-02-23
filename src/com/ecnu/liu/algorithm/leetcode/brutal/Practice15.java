package com.ecnu.liu.algorithm.leetcode.brutal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-10
 * @modified By:
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice15 {
    private static final int INTEGER_THREE_ARRAY = 3;
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length < INTEGER_THREE_ARRAY) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {// 跳过可能重复的答案
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] + nums[i] == 0) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[l]);
                        result.add(nums[i]);
                        result.add(nums[r]);
                        results.add(result);
                        // 这里不能break,不然会漏答案
                        l++;
                        r--;
                        //这里不是l+1，下面也不是r-1，是因为都往中间近了，跟上面操作之前比
                        while (l < r && nums[l] == nums[l-1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r+1]) {
                            r--;
                        }
                    } else if (nums[l] + nums[r] + nums[i] > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }//if
        }//fori
        return results;
    }

    public static void main (String[] args) {
        int[] nums = new int[]{-2,0,0,2,2};
        threeSum(nums);
    }

}
