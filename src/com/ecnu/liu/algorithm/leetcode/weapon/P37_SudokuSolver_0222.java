package com.ecnu.liu.algorithm.leetcode.weapon;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。

 一个数独的解法需遵循如下规则：

 数字 1-9 在每一行只能出现一次。
 数字 1-9 在每一列只能出现一次。
 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 空白格用 '.' 表示。



 一个数独。



 答案被标成红色。

 Note:

 给定的数独序列只包含数字 1-9 和字符 '.' 。
 你可以假设给定的数独只有唯一解。
 给定数独永远是 9x9 形式的。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/sudoku-solver
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P37_SudokuSolver_0222 {

    /**
     * 回溯法
     * 时间复杂度：O(9!)^9
     * 空间复杂度：O(9*3)*81
     * @param board
     */
    public void solveSudoku1(char[][] board) {
        fill(0, 0, board);
    }

    public boolean fill(int row, int col, char[][] board) {
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9) return true;
        }

        if (board[row][col] == '.') {
            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();
            Set<Character> set3 = new HashSet<>();
            for (int i=0; i<9; i++) {
                if (board[row][i] != '.') set1.add(board[row][i]);
            }
            for (int i=0; i<9; i++) {
                if (board[i][col] != '.') set2.add(board[i][col]);
            }
            for (int i=row/3*3; i<(row/3+1)*3; i++) {
                for (int j=col/3*3; j<(col/3+1)*3; j++) {
                    if (board[i][j] != '.') set3.add(board[i][j]);
                }
            }

            for (int i=1; i<=9; i++) {
                char ch = (char)('0'+i);
                if (set1.contains(ch) || set2.contains(ch) || set3.contains(ch)) continue;
                board[row][col] = ch;
                if (fill(row, col+1, board)) return true;
                board[row][col] = '.';
            }
        } else {
            return fill(row, col+1, board);
        }
        return false;
    }



    private int n = 3;
    private int N = 9;
    private boolean[][] rowFlag = new boolean[N][N+1];
    private boolean[][] colFlag = new boolean[N][N+1];
    private boolean[][][] boxFlag = new boolean[n][n][N+1];

    /**
     * 回溯
     * 通过数组存储每一行每一列和每一个9宫格中1-9数组是否被使用来减少判断数字是否可用耗时和减少空间使用
     */
    public void solveSudoku2(char[][] board) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (board[i][j] != '.') {
                    int val = board[i][j] - '0';
                    rowFlag[i][val] = true;
                    colFlag[j][val] = true;
                    boxFlag[i/n][j/n][val] = true;
                }
            }
        }

        fill2(0, 0, board);
    }

    public boolean fill2(int row, int col, char[][] board) {
        if (col == 9) {
            col = 0;
            row++;
            if (row == 9) return true;
        }

        if (board[row][col] == '.') {
            for (int i=1; i<=9; i++) {
                char ch = (char)('0'+i);
                if (rowFlag[row][i] || colFlag[col][i] || boxFlag[row/3][col/3][i]) continue;
                rowFlag[row][i] = true;
                colFlag[col][i] = true;
                boxFlag[row/3][col/3][i] = true;
                board[row][col] = ch;

                if (fill(row, col+1, board)) return true;

                rowFlag[row][i] = false;
                colFlag[col][i] = false;
                boxFlag[row/3][col/3][i] = false;
                board[row][col] = '.';
            }
        } else {
            return fill(row, col+1, board);
        }
        return false;
    }

}
