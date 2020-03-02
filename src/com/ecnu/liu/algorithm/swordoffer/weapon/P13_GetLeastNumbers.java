package com.ecnu.liu.algorithm.swordoffer.weapon;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P13_GetLeastNumbers {

    /**
     * 堆排序:PriorityQueue
     *
     * 时间复杂度：O(nlog2(n))
     * 空间复杂度：O(n)
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> ret = new ArrayList<>();
        if (input.length < k) return ret;
        for(int i=input.length-1; i>=0; i--){
            queue.add(input[i]);
            if (i < k) ret.add(queue.poll());
        }
        return ret;
    }
}

