package com.ecnu.liu.algorithm.swordoffer.brutal;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.algorithm.swordoffer.brutal
 * @date: Created in 2020-02-27
 * @modified By:
 *
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Practice2 {

    /**
     * 思路 最小元素处左侧不是升序的，只需要把所有升序的范围排除掉就可以了
     * @param array
     * @return
     */
//    public int minNumberInRotateArray(int [] array) {
//        if (array == null || array.length ==0) {
//            return 0;
//        }
//        int l = 0;
//        int r = array.length - 1;
//        while (l <= r) {
//            if (r - l <= 1) {
//                return array[r];
//            }
//            int m = (l + r) / 2;
//            if (array[l] < array[m]) {
//                l = m + 1;
//            } else if (array[m] < array[r]) {
//                r = m - 1;
//            } else {
//                return array[m];
//            }
//        }
//        return 0;
//    }

    /**
     * 正解
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if(array.length==0)return 0;
        int left =0;
        int right = array.length-1;
        while(array[left]>=array[right]){//旋转过后前面的数字都会比后面要大，只有最小值那块不满足。
            if(right-left==1)return array[right];
            int mid = (left+right)>>1;
            if(array[left]==array[right]&&array[left]==array[mid])left++;
            else{
                //如果前面的仍然比中点小，表示是正常的仍取原值。不比它小，则表示旋转点（最小值）在后面。
                left = array[left]<=array[mid]?mid:left;
                //如果后面的比中点要大，说明旋转点（最小值）在前面，反之则不变。
                right= array[right]>=array[mid]?mid:right;
            }
        }//while

        return array[left];
    }
}
