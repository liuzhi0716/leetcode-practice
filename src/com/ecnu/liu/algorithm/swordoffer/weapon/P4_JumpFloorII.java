package com.ecnu.liu.algorithm.swordoffer.weapon;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P4_JumpFloorII {

    /**
     * 1. 前target-1个台阶，每个台阶都有两种情况出现，跳与不跳两种，故总情况个数为2^(target-1)
     * 2. f(n) = f(n-1) + f(n-2) + ... + f(n-(n-1)) + f(n-n)  注意f(0)=1; f(1)=1
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        if (target <= 0) return 0;
        // return (int)(Math.pow(2, target-1));
        // return 1 << (target-1);

        int[] dp = new int[target+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=target; i++){
            dp[i] = 0;
            for(int j=0; j<i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }

}
