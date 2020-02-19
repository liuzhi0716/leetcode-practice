package com.ecnu.liu.weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。

 注意：

 答案中不可以包含重复的四元组。

 示例：

 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。

 满足要求的四元组集合为：
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/4sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P18_FourSum_0219 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return ksum(4, nums, target, 0, nums.length-1);
    }

    public List<List<Integer>> ksum(int k, int[] nums, int target, int left, int right) {
        List<List<Integer>> ret = new ArrayList<>();
        if (k > 2) {
            for (int i=left; i<=right; i++) {
                // 在当前[left, right]范围内去重，保留首位数字
                // 当前位置一个批次里面，只允许出现一次，故需要从i>left开始去重
                if (i > left && nums[i] == nums[i-1]) continue;
                List<List<Integer>> tempList = ksum(k-1, nums, target-nums[i], i+1, right);
                for (int j=0; j<tempList.size(); j++) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.addAll(tempList.get(j));
                    ret.add(list);
                }
            }
        } else if (k == 2) {
            while (left < right) {
                int cur = nums[left] + nums[right];
                if (target == cur) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ret.add(list);
                    // 结果去重
                    while (left < right && nums[left+1] == nums[left]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    // 双指针中间靠拢
                    left++;
                    right--;
                } else if (cur > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        P18_FourSum_0219 p18_fourSum_0219 = new P18_FourSum_0219();
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> lists = p18_fourSum_0219.fourSum(nums, 0);
        System.out.println(lists.toString());
    }
}
