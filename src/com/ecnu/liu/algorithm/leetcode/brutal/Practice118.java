package com.ecnu.liu.algorithm.leetcode.brutal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal
 * @date: Created in 2020-02-25
 * @modified By:
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Practice118 {
    /**
     * 找到其中的规律，下面的数等于上面的计数相同处与-1处相加。头尾值为1
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> now = new ArrayList<>();
            if (result.isEmpty()) {
               now.add(1);
            } else {
                List<Integer> last = result.get(result.size() - 1);
                int size = last.size();
                int num = 0;
                //每行比上行要多1个
                while (num < size + 1) {
                    if(num == 0 || num == size) {
                        now.add(1);
                    } else {
                        now.add(last.get(num-1) + last.get(num));
                    }
                    num++;
                }
            }//if
            result.add(now);
        }//for
        return result;
    }

}
