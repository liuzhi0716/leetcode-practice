package com.ecnu.liu.weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 见TwoSum1.java和ThreeSum15.java
 */
public class P1_KSum {

    /**
     * 递归执行
     * ksum问题转换为2sum问题
     * @param nums
     * @param target
     * @param k
     * @param start
     * @param end
     * @return
     */
    public static List<List<Integer>> ksum(int[] nums, int target, int k, int start, int end) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int len = end - start + 1;

        if (k == 2) {
            int left = start;
            int right = end;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ret.add(list);

                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right-1] == nums[right]) right--;
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        } else {
            for (int i=0; i<=len-k+1; i++) {
                if (i>0 && nums[start+i-1] == nums[start+i]) continue;
                List<List<Integer>> temp = ksum(nums, target - nums[start + i], k - 1, start + i + 1, end);
                for (List<Integer> item: temp) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[start+i]);
                    list.addAll(item);
                    ret.add(list);
                }
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -3, -2, -1, 0, 1, 2, 3, 4};
        List<List<Integer>> ksum = ksum(nums, 0, 4, 0, nums.length-1);
        System.out.println(ksum.toString());
    }
}
