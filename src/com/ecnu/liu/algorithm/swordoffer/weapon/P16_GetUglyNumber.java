package com.ecnu.liu.algorithm.swordoffer.weapon;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * https://www.nowcoder.com/practice/6aa9e04fc3794f68acf8778237ba065b?tpId=13&tqId=11186&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P16_GetUglyNumber {

    /**
     * 枚举法
     *
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index < 7) return index;

        int[] dp = new int[index];
        dp[0] = 1;
        int t2=0, t3=0, t5=0;
        for(int i=1; i<index; i++){
            dp[i] = Math.min(dp[t2]*2, Math.min(dp[t3]*3, dp[t5]*5));
            if (dp[i] == dp[t2]*2) t2++;
            if (dp[i] == dp[t3]*3) t3++;
            if (dp[i] == dp[t5]*5) t5++;
        }
        return dp[index-1];
    }

}
