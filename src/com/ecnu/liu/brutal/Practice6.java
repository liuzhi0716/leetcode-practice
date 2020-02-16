package com.ecnu.liu.brutal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-16
 * @modified By:
 *
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Practice6 {

    /**
     * 找到规律以后就很简单了
     * 规律就是每 numRows 个从上到下的 +  numRows - 2 （减去最上面跟最下面的）的为一个周期性
     * 然后是注意到numRows行了就是拐点,拐点后的append用数字去带入
     * 得到array[numRows - 1 - (mod - numRows + 1)]，numRows - 1是数组最后一行，mod - numRows + 1过了拐点向上走的步数。
     *
     */
    public String convert(String s, int numRows) {
        if (s == null || numRows == 1) {
            return s;
        }
        int space = numRows - 2;
        int total = space + numRows;
        StringBuilder[] array = new StringBuilder[numRows];
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int mod = i % total;
            if (mod < numRows) {
                if (array[mod] == null) {
                    array[mod] = new StringBuilder();
                }
                array[mod].append(charArray[i]);
            } else {
                array[numRows - 1 - (mod - numRows + 1)].append(charArray[i]);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }
}
