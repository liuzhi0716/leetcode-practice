package com.ecnu.liu.algorithm.swordoffer.weapon;

import java.util.*;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P20_FindNumsAppearOnce {

    /**
     * 利用map
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<array.length; i++){
            Integer num = map.get(array[i]);
            if (num == null) map.put(array[i], 1);
            else map.put(array[i], num+1);
        }

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        List<Integer> list = new ArrayList<>();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (entry.getValue() == 1) list.add(entry.getKey());
        }
        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }
}
