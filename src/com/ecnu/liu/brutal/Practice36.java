package com.ecnu.liu.brutal;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-21
 * @modified By:
 * <p>
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * ["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice36 {

    /**
     * 最普通的方法，暴力，一行行判定
     *
     * @param board
     * @return
     */
    /**
     * 9个9宫格cell数组: i=0-2时，在第一行123中，由j/3决定在哪个里面，如i=2,j=6  应该在第3格(cell[2])里  2/3*3 + 6/3 = 2正确
     * 每个九宫格装的9个数也要用数组来记，所以要是二维数组，上面只能决定是在哪个格子里，也就是二维数组的第一个值
     * <p>
     * 1 2 3
     * 4 5 6
     * 7 8 9
     */

    public boolean isValidSudoku (char[][] board) {
        //行,列，主要是小九宫格判定
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] cells = new boolean[9][9];
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

    public boolean isValidSudoku2 (char[][] board) {
        //行,列，主要是小九宫格判定
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], cube = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int num = c - '1';

                // row秘书行动
                if (row[i][num]) return false;
                else row[i][num] = true;

                // col秘书
                if (col[j][num]) return false;
                else col[j][num] = true;

                // cube秘书
                int ci = (i / 3) * 3 + (j / 3);
                if (cube[ci][num]) return false;
                else cube[ci][num] = true;
            }
        }
        return true;

    }

}
