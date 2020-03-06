package com.ecnu.liu.algorithm.swordoffer.weapon;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 输出描述:
 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序

 https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P21_FindContinuousSequence {

    /**
     * 穷举 + 双指针法
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer> > ret = new ArrayList<>();
        int i=1, j=1, total=0;
        for(i=1,j=1; i<=sum/2+2; ){
            total += i;
            if (total == sum) {
                if (i-j == 0) break;
                ArrayList<Integer> list = new ArrayList<>();
                for(int k=j; k<=i; k++) list.add(k);
                ret.add(list);
                total -= j;
                j++;
                i++;
            } else if (total > sum) {
                total -= j;
                total -= i;
                j++;
            } else {
                i++;
            }
        }
        return ret;
    }

}

