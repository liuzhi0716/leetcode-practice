package com.ecnu.liu.algorithm.leetcode.brutal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.leetcode.brutal
 * @date: Created in 2020-02-26
 * @modified By:
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 *
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= rowIndex + 1; i++) {
            if (result.isEmpty()) {
                result.add(1);
            } else {
//                List<Integer> last = result.get(result.size() - 1);
                int size = i;
                int num = 0;
                //每行比上行要多1个
                while (num < size + 1) {
                    if (num == 0) {
                        Integer now = result.get(num);
                        now = 1;
                    } else if (num == size) {
                        result.add(1);
                    } else {
                        Integer sum = result.get(num - 1) + result.get(num);
                        Integer now = result.get(num);
                        now = sum;
                    }
                    num++;
                }
            }//if
        }//for
        return result;
    }
}
