package com.ecnu.liu.algorithm.leetcode.brutal;

import java.util.PriorityQueue;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal
 * @date: Created in 2020/3/17
 * @modified By:
 * 414. 第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Practice414 {

    /**
     * 难点1如何限制相同元素进去，优先队列的contains方法没有作用。 先用set装一遍？
     * 难点2小于堆的上限，如何返回最大的。length小于3可以用最大堆，或者直接比较，只保留最大的元素。
     * 题中第三大的数，如果把最小堆的大小弄为3，则堆顶就是最小的数，第三大的数。
     *
     * treeMap可以全部解决
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>(3);
//        for (int i = 0; i < nums.length; i++) {
//            if(heap.contains(nums[i])) {
//                heap.offer(nums[i]);
//            }
//        }
//        return heap.peek();
    }
}
