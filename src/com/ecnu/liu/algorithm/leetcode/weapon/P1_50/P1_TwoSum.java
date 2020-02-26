package com.ecnu.liu.algorithm.leetcode.weapon.P1_50;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/two-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P1_TwoSum {

    /**
     * 暴力解法O(n^2)
     * 两层for循环求和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 利用Map存储差值和下标对
     * 时间复杂度O(n)，空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if (i > 0) {
                Integer idx = map.get(nums[i]);
                if (idx != null) {
                    return new int[]{idx, i};
                }
            }
            map.put(target-nums[i], i);
        }
        return null;
    }

    /**
     * 利用Arrays.sort()排序，然后从两端向中间靠拢
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum3(int[] nums, int target) {
        Data[] datas = new Data[nums.length];
        for(int i=0; i<nums.length; i++) {
            datas[i] = new Data(nums[i], i);
        }
        Arrays.sort(datas);
        int temp = 0;
        for(int i=0, j=nums.length-1; i<j; ) {
            temp = datas[i].getNum() + datas[j].getNum();
            if (temp == target) return new int[]{datas[i].getIdx(), datas[j].getIdx()};
            if (temp > target) j--;
            if (temp < target) i++;
        }
        return null;
    }

    class Data implements Comparable<Data> {

        private int num;
        private int idx;

        public Data(int num, int idx){
            this.num = num;
            this.idx = idx;
        }

        public int getNum() {
            return num;
        }

        public int getIdx() {
            return idx;
        }

        @Override
        public int compareTo(Data o1) {
            return this.num - o1.num;
        }
    }
}
