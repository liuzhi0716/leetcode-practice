package com.ecnu.liu.algorithm.leetcode.weapon;

public class P6_ZigzagConversion {

    /**
     * 通过数组存储字符，然后遍历数组
     * 时间复杂度O(len+row*col)
     * @param s
     * @param numRows
     * @return
     */
    public String convert1(String s, int numRows) {
        int len = s.length();
        if (len <= numRows || numRows == 1) return s;
        int col = (len/(2*numRows-2))*(numRows-1) + 1 + (len%(2*numRows-2))%numRows;
        char[][] chs = new char[numRows][col];

        int r=0, c=0;
        boolean flag = true;
        for (int i=0; i<len; i++) {
            chs[r][c] = s.charAt(i);
            if (flag) {
                r++;
                if (r == numRows-1) flag = false;
            } else {
                r--;
                c++;
                if (r == 0) flag = true;
            }
        }

        StringBuffer ret = new StringBuffer();
        for (int i=0; i<numRows; i++) {
            for (int j=0; j<col; j++) {
                if (chs[i][j] != 0) ret.append(chs[i][j]);
            }
        }
        return ret.toString();
    }

    /**
     * 通过确定每一行字符位置，来拼接结果
     * 每一批次字符个数：2*numRows - 2
     * 第一行：k*(2*numRows - 2) + i   k从0开始，且 i=0
     * 竖行第i行：k*(2*numRows - 2) + i      k从0开始，且 i>0
     * 内部的第i行：(k+1)*(2*numRows - 2) - i     i!=0 && i!=(numRows-1)
     */
}
