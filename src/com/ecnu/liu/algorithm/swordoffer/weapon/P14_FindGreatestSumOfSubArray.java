package com.ecnu.liu.algorithm.swordoffer.weapon;

/**
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P14_FindGreatestSumOfSubArray {

    /**
     * 数组运算
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray1(int[] array) {
        if (array == null || array.length == 0) return 0;
        int max = array[0];
        int cur = array[0];
        for (int i=1; i<array.length; i++){
            cur += array[i];
            if (cur > max) max = cur;
            else if (cur < 0) cur = 0;
        }
        return max;
    }

    /**
     * dp
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray2(int[] array) {
        if (array == null || array.length == 0) return 0;
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0];
        for(int i=1; i<array.length; i++){
            dp[i] = Math.max(dp[i-1]+array[i], array[i]);
            if (max < dp[i]) max = dp[i];
        }
        return max;
    }
}
