package com.ecnu.liu.algorithm.leetcode.weapon.P1_50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。

 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。

  

 示例 1：

 输入：
 s = "barfoothefoobarman",
 words = ["foo","bar"]
 输出：[0,9]
 解释：
 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 输出的顺序不重要, [9,0] 也是有效答案。
 示例 2：

 输入：
 s = "wordgoodgoodgoodbestword",
 words = ["word","good","best","word"]
 输出：[]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P30_SubstringWithConcatenationOfAllWords_0224 {

    private Set<String> strs = new HashSet<>();

    /**
     * 先找出单词的排列组合，然后遍历并截取固定长度的字符串进行比较
     * 此种方式超时了
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring1(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s.length()==0 || words.length==0) return list;

        int[] mark = new int[words.length];
        String[] temp = new String[words.length];

        run(words, mark, 0, temp);

        int len = words.length * words[0].length();
        for (int i=0; i<=s.length()-len; i++) {
            String str = s.substring(i, i+len);
            if (strs.contains(str)) list.add(i);
        }

        return list;
    }

    public void run(String[] words, int[] mark, int cur, String[] temp) {
        if (cur == words.length) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<temp.length; j++) sb.append(temp[j]);
            strs.add(sb.toString());

        } else {
            for (int i=0; i<mark.length; i++) {
                if (mark[i] == 0) {
                    temp[cur] = words[i];

                    mark[i] = 1;
                    run(words, mark, cur+1, temp);
                    mark[i] = 0;
                }
            }
        }

    }
}
