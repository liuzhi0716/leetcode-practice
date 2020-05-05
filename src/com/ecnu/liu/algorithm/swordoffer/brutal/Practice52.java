package com.ecnu.liu.algorithm.swordoffer.brutal;


/**
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 */
public class Practice52 {

    public int GetNumberOfK(int [] array , int k) {
       int l = getLow(array, k);
       int h = getHigh(array, k);
       if (l == -1 || h == -1) {
           return 0;
       }
       return h-l+1;
    }


    public int getLow (int [] array , int k) {
        int l = 0;
        int h = array.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (array[mid] == k ) {
                if (mid == 0 || (mid > 0 && array[mid-1] != k)) {
                    return mid;
                } else {
                    h = mid - 1;
                }
            } else if (array[mid] > k) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int getHigh(int [] array , int k) {
        int l = 0;
        int h = array.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (array[mid] == k ) {
                if (mid == array.length-1 || (mid < array.length-1  && array[mid+1] != k)) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            } else if (array[mid] > k) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
