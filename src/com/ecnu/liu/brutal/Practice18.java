package com.ecnu.liu.brutal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-18
 * @modified By:
 * <p>
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice18 {

    public static List<List<Integer>> fourSum (int[] nums, int target) {
        int[] array = Arrays.copyOf(nums, nums.length);
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < array.length; j++) {
                //这里一定要是大于i+1而不是固定数不然会出现i与j位置的数同时相等错过正确答案
                if (j > i + 1 && array[j] == array[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                int k = target - array[i] - array[j];
                while (l < r) {
                    if (array[l] + array[r] == k) {
                        List<Integer> list = new ArrayList<>();
                        list.add(array[i]);
                        list.add(array[j]);
                        list.add(array[l]);
                        list.add(array[r]);
                        result.add(list);
                        r--;
                        while (r > l && array[r] == array[r + 1]) {
                            r--;
                        }
                        l++;
                        while (r > l && array[l] == array[l - 1]) {
                            l++;
                        }
                    } else if (array[l] + array[r] > k) {
                        r--;
                        while (r > l && array[r] == array[r + 1]) {
                            r--;
                        }
                    } else {
                        l++;
                        while (r > l && array[l] == array[l - 1]) {
                            l++;
                        }
                    }
                }

            }
        }
        return result;
    }

    public static void main (String[] args) {
        int[] num = new int[]{-1,0,1,2,-1,-4};
        fourSum(num, -1);
    }
}
