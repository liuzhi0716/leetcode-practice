package com.ecnu.liu.algorithm.leetcode.weapon.P51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



 上图为 8 皇后问题的一种解法。

 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

 示例:

 输入: 4
 输出: [
 [".Q..",  // 解法 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // 解法 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 解释: 4 皇后问题存在两个不同的解法。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/n-queens
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P51_SolveNQueens {

    /**
     * 回溯
     *
     * 时间复杂度：O(n!)
     * 空间复杂度：O(n*n)
     */
    List<List<String>> ret = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chs = new char[n][n];
        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++) {
                chs[i][j] = '.';
            }
        }

        run(chs, n, 0);
        return ret;
    }

    public void run(char[][] chs, int n, int idx) {
        if (idx == n) {
            List<String> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(String.valueOf(chs[i]));
            }
            ret.add(list);
        } else {
            for(int i=0; i<n; i++) {
                if (!check(chs, n, idx, i)) continue;
                chs[idx][i] = 'Q';
                run(chs, n, idx+1);
                chs[idx][i] = '.';
            }
        }
    }

    public boolean check(char[][] chs, int n, int row, int col) {
        for (int j=0; j<n; j++) {
            if (chs[row][j]=='Q' || chs[j][col]=='Q') return false;
        }

        int r = row, c = col;
        while(r>=0 && c>=0) {
            if (chs[r][c]=='Q') return false;
            r--;
            c--;
        }

        r = row;
        c = col;
        while(r<n && c<n) {
            if (chs[r][c]=='Q') return false;
            r++;
            c++;
        }

        r = row;
        c = col;
        while(r>=0 && c<n) {
            if (chs[r][c]=='Q') return false;
            r--;
            c++;
        }

        r = row;
        c = col;
        while(r<n && c>=0) {
            if (chs[r][c]=='Q') return false;
            r++;
            c--;
        }


        return true;
    }

}
