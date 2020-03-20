package com.ecnu.liu.algorithm.leetcode.weapon.P51_100;

import com.ecnu.liu.algorithm.struct.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

 示例:

 输入: 3
 输出:
 [
 [1,null,3,2],
 [3,2,null,1],
 [3,1,null,null,2],
 [2,1,3],
 [1,null,2,null,3]
 ]
 解释:
 以上的输出对应以下 5 种不同结构的二叉搜索树：

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 */
public class P96_UniqueBinarySearchTreesII_0320 {

    /**
     * 递归
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<TreeNode>();
        return generateTree(1, n);
    }

    public LinkedList<TreeNode> generateTree(int start, int end) {
        LinkedList<TreeNode> all = new LinkedList<>();
        if (start > end) {
            all.add(null);
            return all;
        }
        for(int i=start; i<=end; i++) {
            LinkedList<TreeNode> left = generateTree(start, i-1);
            LinkedList<TreeNode> right = generateTree(i+1, end);
            for(TreeNode l: left) {
                for(TreeNode r: right) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    all.add(cur);
                }
            }
        }
        return all;
    }

}
