package com.ecnu.liu.algorithm.leetcode.brutal;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-17
 * @modified By:
 */
public class Practice11 {

    /**
     * 暴力，最大面积等于端点距离乘两者最小高
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = (j-i) * Math.min(height[i], height[j]);
                area = temp > area ? temp : area;
            }
        }
        return area;
    }

    /**
     * 双指针往中间逼近，有个疑问就是两边高度相等的时候，谁继续往中间走
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int area = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            int temp = (r-l) * Math.min(height[l], height[r]);
            area = temp > area ? temp : area;
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return area;
    }
}
