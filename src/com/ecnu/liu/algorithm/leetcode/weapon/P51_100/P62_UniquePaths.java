package com.ecnu.liu.algorithm.leetcode.weapon.P51_100;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

 问总共有多少条不同的路径？

 示例 1:

 输入: m = 3, n = 2
 输出: 3
 解释:
 从左上角开始，总共有 3 条路径可以到达右下角。
 1. 向右 -> 向右 -> 向下
 2. 向右 -> 向下 -> 向右
 3. 向下 -> 向右 -> 向右
 示例 2:

 输入: m = 7, n = 3
 输出: 28
  

 提示：

 1 <= m, n <= 100
 题目数据保证答案小于等于 2 * 10 ^ 9

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/unique-paths
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P62_UniquePaths {

    /**
     * 动态规划
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int[][] bp = new int[m][n];
        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 || j==0) bp[i][j] = 1;
                else bp[i][j] = bp[i-1][j]+bp[i][j-1];
            }
        }
        return bp[m-1][n-1];
    }
}
