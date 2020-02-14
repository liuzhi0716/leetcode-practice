package com.ecnu.liu.weapon;

import java.util.*;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 示例 2:

 输入: "bbbbb"
 输出: 1
 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 示例 3:

 输入: "pwwkew"
 输出: 3
 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring3 {

    /**
     * 利用数据结构hashmap，key为字符，value为字符的下标值
     * 遍历字符串，通过map找到相同字符的下标值，然后移除下标值之前的字符
     * 时间复杂度O(2n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int len = 0;
        int first = 0;
        for (int i=0; i<s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int idx = map.get(ch);
                for (int j=first; j<=idx; j++) {
                    map.remove(new Character(s.charAt(j)));
                }
                if (len > max) {
                    max = len;
                }
                len = len - (idx - first);
                first = idx + 1;

            } else {
                len++;
            }
            map.put(new Character(ch), new Integer(i));
        }
        if (len > max) max = len;
        return max;
    }

    /**
     * 利用滑动窗口，加上set判重
     * 时间复杂度同上O(2n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, max = 0;
        while (i <= j && j < s.length()) {
            Character ch = s.charAt(j);
            if (set.contains(ch)) {
                max = Math.max(max, j-i);
                while (s.charAt(i) != s.charAt(j)) set.remove(s.charAt(i++));
                i++;
            } else {
                set.add(ch);
            }
            j++;
        }
        return Math.max(max, j-i);
    }

    /**
     * 利用滑动窗口，加上set判重
     * 思路同解法2，本方法目的为简单代码
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, max = 0;
        while (i <= j && j < s.length()) {
            if (set.contains(s.charAt(j))) {
                max = Math.max(max, j-i);
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
            }
        }
        return Math.max(max, j-i);
    }

    /**
     * 利用hashmap，但不做remove操作
     * 保证滑动窗口的左边下标值始终大于当前值
     * 对比解法1
      */
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * 利用数组存储字符对应的下标值，128个字符，长度为128
     */
    public int lengthOfLongestSubstring5(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

}
