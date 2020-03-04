package com.ecnu.liu.algorithm.swordoffer.weapon;

import java.util.*;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 * https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P17_FirstNotRepeatingChar {

    /**
     * 利用有序hashmap，即LinkedHashMap来统计字母的个数和下标
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0) return -1;

        LinkedHashMap<Character, List<Integer>> map = new LinkedHashMap<>();
        for (int i=0; i<str.length(); i++) {
            List<Integer> list = map.get(str.charAt(i));
            if (list == null) {
                list = new ArrayList<>(2);
                list.add(1);
                list.add(i);
                map.put(str.charAt(i), list);
            }else {
                list.set(0, list.get(0)+1);
            }
        }

        Iterator<Map.Entry<Character, List<Integer>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, List<Integer>> entry = it.next();
            if (entry.getValue().get(0) == 1) return entry.getValue().get(1);
        }

        return -1;
    }

}
