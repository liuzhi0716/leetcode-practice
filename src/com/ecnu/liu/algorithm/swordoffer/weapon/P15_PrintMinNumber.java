package com.ecnu.liu.algorithm.swordoffer.weapon;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P15_PrintMinNumber {

    /**
     * 回溯
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    String min = null;
    public String PrintMinNumber(int [] numbers) {
        int[] mark = new int[numbers.length];
        int[] tmp = new int[numbers.length];

        go(numbers, mark, tmp, 0);
        return String.valueOf(min);
    }

    public void go(int[] numbers, int[] mark, int[] tmp, int cur){
        if (cur == numbers.length) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<numbers.length; i++) sb.append(tmp[i]);

            if (min == null) min = sb.toString();
            else min = min.compareTo(sb.toString()) > 0 ? sb.toString() : min;
        } else {
            for(int i=0; i<numbers.length; i++) {
                if (mark[i] == 1) continue;
                mark[i] = 1;
                tmp[cur] = numbers[i];
                go(numbers, mark, tmp, cur+1);
                mark[i] = 0;
                tmp[cur] = 0;
            }
        }
    }

}
