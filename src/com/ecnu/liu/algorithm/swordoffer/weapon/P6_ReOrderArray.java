package com.ecnu.liu.algorithm.swordoffer.weapon;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P6_ReOrderArray {

    /**
     * 最坏时间复杂度：O(n^2)
     * 最好时间复杂度：O(n)
     * @param array
     */
    public void reOrderArray1(int [] array) {
        int cur = -1;
        for(int i=0; i<array.length; i++) {
            if (array[i] % 2 == 0) {
                int j = Math.max(cur+1, i+1);
                while(j < array.length && array[j] % 2 == 0) j++;
                if (j < array.length) {
                    int temp = array[i];
                    array[i] = array[j];
                    for(int k=j; k>i+1; k--) array[k]=array[k-1];
                    array[i+1] = temp;
                    cur = j;
                }
            }

        }
    }

    /**
     * 插入法
     * 耗时比reOrderArray1()还高
     * @param array
     */
    public void reOrderArray2(int [] array) {
        int k = 0;
        for(int i=0; i<array.length; i++) {
            if (array[i] % 2 == 1) {
                int j=i;
                while (j > k) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    j--;
                }
                k++;
            }
        }
    }
}
