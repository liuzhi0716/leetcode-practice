package com.ecnu.liu.algorithm.leetcode.weapon.P51_100;

/**
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

 说明：每次只能向下或者向右移动一步。

 示例:

 输入:
 [
   [1,3,1],
 [1,5,1],
 [4,2,1]
 ]
 输出: 7
 解释: 因为路径 1→3→1→1→1 的总和最小。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-path-sum
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P64_MinPathSum {

    /**
     * 动态规划
     *
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] bp = new int[m][n];
        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 && j==0) bp[i][j] = grid[0][0];
                else if (i==0) bp[i][j] = bp[i][j-1] + grid[i][j];
                else if (j==0) bp[i][j] = bp[i-1][j] + grid[i][j];
                else bp[i][j] = Math.min(bp[i-1][j], bp[i][j-1]) + grid[i][j];
            }
        }
        return bp[m-1][n-1];
    }

}
