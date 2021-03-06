package com.ecnu.liu.algorithm.leetcode.weapon.P1_50;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

 数字 1-9 在每一行只能出现一次。
 数字 1-9 在每一列只能出现一次。
 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


 上图是一个部分填充的有效的数独。

 数独部分空格内已填入了数字，空白格用 '.' 表示。

 示例 1:

 输入:
 [
 ["5","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 输出: true
 示例 2:

 输入:
 [
   ["8","3",".",".","7",".",".",".","."],
   ["6",".",".","1","9","5",".",".","."],
   [".","9","8",".",".",".",".","6","."],
   ["8",".",".",".","6",".",".",".","3"],
   ["4",".",".","8",".","3",".",".","1"],
   ["7",".",".",".","2",".",".",".","6"],
   [".","6",".",".",".",".","2","8","."],
   [".",".",".","4","1","9",".",".","5"],
   [".",".",".",".","8",".",".","7","9"]
 ]
 输出: false
 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 说明:

 一个有效的数独（部分已被填充）不一定是可解的。
 只需要根据以上规则，验证已经填入的数字是否有效即可。
 给定数独序列只包含数字 1-9 和字符 '.' 。
 给定数独永远是 9x9 形式的。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/valid-sudoku
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P36_ValidSudoku {

    /**
     * 三趟遍历
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     * @param board
     * @return
     */
    public boolean isValidSudoku1(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] == '.') continue;
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
            set.clear();
        }

        for (int i = 0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[j][i] == '.') continue;
                if (set.contains(board[j][i])) return false;
                set.add(board[j][i]);
            }
            set.clear();
        }

        for (int i = 0; i<9; i+=3) {
            for (int j=0; j<9; j+=3) {
                for (int m=i; m<i+3; m++) {
                    for (int n=j; n<j+3; n++) {
                        if (board[m][n] == '.') continue;
                        if (set.contains(board[m][n])) return false;
                        set.add(board[m][n]);
                    }
                }
                set.clear();
            }

        }
        return true;
    }

    /**
     * 一趟遍历
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] cells = new boolean[9][9];
        //行,列，主要是小九宫格判定
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    int now = board[i][j] - '1';
                    if (rows[i][now]) {
                        return false;
                    } else {
                        rows[i][now] = true;
                    }
                    if (cols[j][now]) {
                        return false;
                    } else {
                        cols[j][now] = true;
                    }
                    //算九宫格是哪一个小格里,需要*3 不然ij都是8的时候明显不正确
                    int num = i / 3 * 3 + j / 3;
                    if (cells[num][now]) {
                        return false;
                    } else {
                        cells[num][now] = true;
                    }
                }
            }
        }
        return true;
    }

}
