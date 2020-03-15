package com.ecnu.liu.algorithm.leetcode.weapon.P51_100;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 示例:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 给定 word = "ABCCED", 返回 true.
 给定 word = "SEE", 返回 true.
 给定 word = "ABCB", 返回 false.

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/word-search
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P79_WordSearch {

    /**
     * dfs
     * 时间复杂度：O(row*col*len(word))
     * 空间复杂度：O(len(word)) + O(row*col)
     */
    boolean ret = false;
    public boolean exist1(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] mark = new boolean[row][col];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                dfs(board, word, mark, 0, i, j);
                if (ret) break;
            }
        }

        return ret;
    }

    public void dfs(char[][] board, String word, boolean[][] mark, int idx, int r, int c) {
        if (idx >= word.length()) {
            ret = true;
            return;
        }

        if (ret) return;
        if (r<0 || c<0 || r>=board.length || c>=board[0].length) return;
        if (mark[r][c]) return;

        if(board[r][c] == word.charAt(idx)) {
            mark[r][c] = true;
            dfs(board, word, mark, idx+1, r, c-1);
            dfs(board, word, mark, idx+1, r-1, c);
            dfs(board, word, mark, idx+1, r, c+1);
            dfs(board, word, mark, idx+1, r+1, c);
            mark[r][c] = false;
        }

    }

}
