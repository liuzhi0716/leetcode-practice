package com.ecnu.liu.algorithm.swordoffer.weapon;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class P3_MinNumberInRotateArray {

    /**
     * 二分算法
     * 以第一个数字为基准，每一个中间数跟第一个数字比较，若大于等于，则left=mid+1；若小于，则right=mid
     * 时间复杂度：O(log(n))
     * 空间复杂度：O(1)
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) return 0;

        int left=0;
        int right=array.length-1;
        int mid = -1;
        while (left < right) {
            mid = (left+right) / 2;
            if (array[mid] >= array[0]) {
                left = mid+1;
            } else {
                right = mid;
            }
        }

        return array[right];
    }
}
