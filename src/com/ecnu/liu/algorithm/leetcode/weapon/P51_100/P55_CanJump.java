package com.ecnu.liu.algorithm.leetcode.weapon.P51_100;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 判断你是否能够到达最后一个位置。

 示例 1:

 输入: [2,3,1,1,4]
 输出: true
 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 示例 2:

 输入: [3,2,1,0,4]
 输出: false
 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/jump-game
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P55_CanJump {

    /**
     * 回溯，超时了
     *
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        return run(nums, 0);
    }

    public boolean run(int[] nums, int idx) {
        if (idx >= nums.length-1) {
            return true;
        } else {
            int num = nums[idx];
            for (int i=num; i>=1; i--) {
                if(run(nums, idx+i)) {
                    return true;
                }
            }
            return false;
        }

    }

    /**
     * 贪心算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
