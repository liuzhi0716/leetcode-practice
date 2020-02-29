package com.ecnu.liu.algorithm.swordoffer.weapon;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

 比如n=3时，2*3的矩形块有3种覆盖方法：

 https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

 */
public class P5_RectCover {

    /**
     * 斐波那契数列
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        else if (target == 2) return 2;
        else return RectCover(target-1) + RectCover(target-2);
    }

}
