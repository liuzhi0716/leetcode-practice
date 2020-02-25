package com.ecnu.liu.algorithm.leetcode.brutal.fifty;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-21
 * @modified By:
 */
public class Practice26 {

    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int l = 0;
        int space = 0;
        //比较以后相等将每次的space拉开，因为l是从最初往后的，所以会自动吧相等的数的位置填上
        for (int i = 1; i < nums.length; i++) {
            if (nums[l] == nums[i]) {
                space++;
            } else {
                nums[i-space] = nums[i];
                l++;
            }
        }
        return nums.length  - space;
    }

    public static void main (String[] args) {
        removeDuplicates(new int[]{1,1,2});
    }
}
