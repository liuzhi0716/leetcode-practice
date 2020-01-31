package com.ecnu.liu.brutal;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-01-31
 * @modified By:
 */
public class Practice7 {

    /**
     * 方法一:该方法的效率不高
     * @param x
     * @return
     */
    public int reverse(int x) {
        try{
            if (x >= 0) {
                return Integer.valueOf(new StringBuffer(String.valueOf(x)).reverse().toString());
            } else {
                String s = String.valueOf(x).substring(1);
                return Integer.valueOf("-" + new StringBuffer(s).reverse().toString());
            }
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 方法二:循环累加,如果加的值溢出整形最大值、最小值则返回0
     */
}
