package com.ecnu.liu.algorithm.swordoffer.weapon;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 输出描述:
 如果当前字符流没有存在出现一次的字符，返回#字符。

 https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P25_FirstAppearingOnce {

    HashSet<Character> set = new HashSet<>();
    LinkedHashSet<Character> lset = new LinkedHashSet<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (set.contains(ch)) return;
        if (lset.contains(ch)) {
            set.add(ch);
            lset.remove(ch);
        } else {
            lset.add(ch);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (lset.size()>0) return lset.iterator().next();
        else return '#';
    }


}
