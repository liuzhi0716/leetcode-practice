package com.ecnu.liu.algorithm.swordoffer.weapon;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P8_PrintMatrix {

    /**
     * 循环遍历
     *
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(1)
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix1(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;

        int up = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;

        while (true) {
            for (int col=left; col<=right; col++) list.add(matrix[up][col]);
            up++;
            if (up > down) break;
            for (int row=up; row<=down; row++) list.add(matrix[row][right]);
            right--;
            if (left > right) break;
            for (int col=right; col>=left; col--) list.add(matrix[down][col]);
            down--;
            if (up > down) break;
            for (int row=down; row>=up; row--) list.add(matrix[row][left]);
            left++;
            if (left > right) break;
        }

        return list;
    }
}
