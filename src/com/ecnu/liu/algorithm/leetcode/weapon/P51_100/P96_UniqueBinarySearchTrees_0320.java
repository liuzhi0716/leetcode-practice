package com.ecnu.liu.algorithm.leetcode.weapon.P51_100;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

 示例:

 输入: 3
 输出: 5
 解释:
 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class P96_UniqueBinarySearchTrees_0320 {

    /**
     *
     F(i,n)=G(i−1)*G(n−i)

           i=1
     G(n)= ∑ G(i−1)⋅G(n−i)
           n
     ​
     时间复杂度：O(N^2)
     空间复杂度：O(N)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = 1;
        G[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                G[i] += G[j-1]*G[i-j];
            }
        }
        return G[n];
    }
}
