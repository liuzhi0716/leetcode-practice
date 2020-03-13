package com.ecnu.liu.algorithm.leetcode.brutal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal
 * @date: Created in 2020/3/13
 * @modified By:
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice347 {

    public class Node {
        private Integer key;
        private Integer count;

        public Node (Integer key, Integer count) {
            this.key = key;
            this.count = count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            Integer key = nums[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        List<Node> nodes = new ArrayList<>();
        for(Map.Entry entry :map.entrySet()) {
            Node node = new Node((Integer) entry.getKey(), (Integer) entry.getValue());
            nodes.add(node);
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare (Node o1, Node o2) {
                return o2.count-o1.count;
            }
        });
        for (int i = 0; i < nodes.size(); i++) {
            priorityQueue.offer(nodes.get(i));
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(priorityQueue.poll().key);
        }
        return result;
    }



    //官方解法:
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        // build hash map : character and how often it appears
//        HashMap<Integer, Integer> count = new HashMap();
//        for (int n: nums) {
//            count.put(n, count.getOrDefault(n, 0) + 1);
//        }
//
//        // init heap 'the less frequent element first'
//        PriorityQueue<Integer> heap =
//            new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));
//
//        // keep k top frequent elements in the heap
//        for (int n: count.keySet()) {
//            heap.add(n);
//            if (heap.size() > k)
//                heap.poll();
//        }
//
//        // build output list
//        List<Integer> top_k = new LinkedList();
//        while (!heap.isEmpty())
//            top_k.add(heap.poll());
//        Collections.reverse(top_k);
//        return top_k;
//    }
//
//    链接：https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode/

}
