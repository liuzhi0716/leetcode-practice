package com.ecnu.liu.algorithm.leetcode.weapon.P151_P200;

/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。

 示例 1:

 输入:
 11110
 11010
 11000
 00000

 输出: 1
 示例 2:

 输入:
 11000
 11000
 00100
 00011

 输出: 3

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/number-of-islands
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P200_NumIslands_0322 {

    /**
     * dfs
     *
     * 时间复杂度：O(M*N)
     * 空间复杂度：O(M*N)
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        int num = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int r, int c){
        if (r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]=='0') return;
        grid[r][c] = '0';
        dfs(grid, r+1, c);
        dfs(grid, r, c+1);
        dfs(grid, r-1, c);
        dfs(grid, r, c-1);
    }

}
