package com.ecnu.liu.algorithm.swordoffer.brutal;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.swordoffer.brutal
 * @date: Created in 2020-02-28
 * @modified By:
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Practice4 {
    /**
     * 1是直接上来的这一步
     * dp[n] = dp[n-1] + dp[n-2] +...+d[1] + 1
     * dp[1] = 1
     * dp
     *
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        int dp[] = new int[target];
        dp[0] = 1;
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
            dp[i]+=1;
        }
        return dp[target-1];
    }

}
