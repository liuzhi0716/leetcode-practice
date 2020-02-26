package com.ecnu.liu.algorithm.leetcode.weapon.P1_50;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

 示例 1:

 输入: 121
 输出: true
 示例 2:

 输入: -121
 输出: false
 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 示例 3:

 输入: 10
 输出: false
 解释: 从右向左读, 为 01 。因此它不是一个回文数。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/palindrome-number
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P9_IsPalindrome {

    /**
     * 利用字符串反转再比较字符串
     *
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        if (x < 0) return false;
        String s1 = String.valueOf(x);
        String s2 = new StringBuffer(s1).reverse().toString();
        if (s1.equals(s2)) return true;
        else return false;
    }

    /**
     * 双指针遍历字符串
     *
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        String s1 = String.valueOf(x);
        int i = 0, j = s1.length()-1;
        while (i < j) {
            if (s1.charAt(i) != s1.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * 取余取整求回文整数
     *
     * while (x != 0) {
         int pop = x % 10;
         x /= 10;
         if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
         if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
         rev = rev * 10 + pop;
      }
     */
    public boolean isPalindrome3(int x) {
        int x1 = x;
        if (x < 0) return false;
        int temp = 0;
        while (x > 0) {
            int pop = x%10;
            x = x/10;
            if (temp > Integer.MAX_VALUE/10 || (temp == Integer.MAX_VALUE/10 && pop > Integer.MAX_VALUE%10)) return false;
            temp = temp*10 + pop;
        }
        if (x1 == temp) return true;
        else return false;
    }

    public static void main(String[] args) {
        P9_IsPalindrome p9_isPalindrome = new P9_IsPalindrome();
        boolean palindrome3 = p9_isPalindrome.isPalindrome3(1000000001);
        System.out.println(palindrome3);
    }
}
