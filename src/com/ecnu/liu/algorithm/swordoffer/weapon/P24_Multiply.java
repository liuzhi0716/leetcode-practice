package com.ecnu.liu.algorithm.swordoffer.weapon;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 *
 * https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 */
public class P24_Multiply {

    /**
     * 两次遍历
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int res = 1;
        for(int i=0; i<A.length; i++){
            B[i] = res;
            res *= A[i];
        }
        res = 1;
        for (int i=A.length-1; i>=0; i--) {
            B[i] = B[i]*res;
            res *= A[i];
        }
        return B;
    }
}
