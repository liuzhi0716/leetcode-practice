package com.ecnu.liu.algorithm.leetcode.weapon.P51_100;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

 网格中的障碍物和空位置分别用 1 和 0 来表示。

 说明：m 和 n 的值均不超过 100。

 示例 1:

 输入:
 [
   [0,0,0],
   [0,1,0],
   [0,0,0]
 ]
 输出: 2
 解释:
 3x3 网格的正中间有一个障碍物。
 从左上角到右下角一共有 2 条不同的路径：
 1. 向右 -> 向右 -> 向下 -> 向下
 2. 向下 -> 向下 -> 向右 -> 向右

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/unique-paths-ii
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P63_UniquePathsWithObstacles {

    /**
     * 动态规划
     *
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] bp = new int[m][n];
        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (obstacleGrid[i][j] == 1) bp[i][j]=0;
                else if (i==0 && j==0) bp[i][j] = 1;
                else if (i==0) bp[i][j] = bp[i][j-1];
                else if (j==0) bp[i][j] = bp[i-1][j];
                else bp[i][j] = bp[i-1][j]+bp[i][j-1];
            }
        }
        return bp[m-1][n-1];
    }
}
