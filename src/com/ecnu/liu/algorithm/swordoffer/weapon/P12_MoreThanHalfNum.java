package com.ecnu.liu.algorithm.swordoffer.weapon;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P12_MoreThanHalfNum {

    /**
     * 利用空间换时间
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0) return 0;
        if (array.length == 1) return array[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<array.length; i++) {
            Integer val = map.get(array[i]);
            if (val == null) map.put(array[i], 1);
            else if (val+1 > array.length/2) return array[i];
            else map.put(array[i], val+1);
        }
        return 0;
    }

}
