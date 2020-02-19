package com.ecnu.liu.brutal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-01-29
 * @modified By:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Practice3 {

    /**
     * dp[0] = 1
     * dp[i] = max(dp[i-1]+1, array[i]
     */
    public static int lengthOfLongestSubstring (String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int maxLen = 1;
        int len = 1;
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            //说明又出现了
            Character character = s.charAt(i);
            Integer last = map.get(character);
            if (map.containsKey(character) && last >= start) {
                maxLen = maxLen > len ? maxLen : len;
                //从上次出现的后面一位开始算
                start = last + 1;
                //总长度是i-last,未到i,需要加+1，往后移一位开始算长度需要-1，故不加不减;
                len = i - last;
            } else {
                len++;
            }
            map.put(character, i);
        }
        maxLen = maxLen > len ? maxLen : len;
        return maxLen;
    }

    public static void main (String[] args) {
        lengthOfLongestSubstring("bbbbb");
    }
}