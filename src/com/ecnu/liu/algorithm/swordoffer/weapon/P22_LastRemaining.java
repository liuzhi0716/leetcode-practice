package com.ecnu.liu.algorithm.swordoffer.weapon;

import java.util.ArrayList;
import java.util.List;

/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)

 如果没有小朋友，请返回-1

 https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P22_LastRemaining {

    /**
     * 链表移除法
     * 时间复杂度：O(n+n-1+n-2+...+1 = (n+1)*n/2) = O(n^2)
     * 空间复杂度：O(n)
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n==0 || m==0) return -1;
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) list.add(i);

        int last = 0;
        while (list.size() > 1) {
            last += (m-1);
            last = last % list.size();
            list.remove(last);
        }
        return list.get(0);
    }

}
