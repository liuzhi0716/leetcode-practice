package com.ecnu.liu.algorithm.leetcode.brutal;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal
 * @date: Created in 2020/3/15
 * @modified By:
 * 79. 单词搜索
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Practice79 {

//    public boolean exist(char[][] board, String word) {
//        int m = board.length;
//        int n = board[0].length;
//        boolean [][]used  = new boolean[m][n];
//
//    }
//
//    public boolean dfs(char[][] board, boolean [][]used, int row, int col, String str, String word, int m, int n) {
//        if (word.equals(str)) {
//            return true;
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                str += board[i][j];
//            }
//        }
//    }
}
