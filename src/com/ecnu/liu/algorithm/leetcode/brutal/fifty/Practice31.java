package com.ecnu.liu.algorithm.leetcode.brutal.fifty;

/**
 * @author: create by liuxiansen
 * @description: com.ecnu.liu.brutal
 * @date: Created in 2020-02-22
 * @modified By:
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Practice31 {

    /**
     *
     * 从最右边开始，设最右边的数是nums[i]，那么每次从i的右边寻找，看能不能找到一个数比i大，如果有，就交换它们，并把i右边的数由小到大排序，如果找不到，就i--，继续下一次寻找
     *
     * 为什么这样做呢？
     *
     * 因为我想找一个比当前数字大的数，并且这个数需要在某个位上比当前数字大，那么我们只需要找到某个位于高位的数，这个数比低位上的某个数要小，交换它们，就可以使我们找到的数比当前数字大了。
     *
     * 又因为我们要找的数需要是最接近当前数字的数，所以我们需要从右边每个位开始找，判断是否它的低位（即右边）是否有比它大的数，有我们就交换它们，此外这样还不够接近，还需要把低位上的所有数排序一遍，才能是最接近的数
     * 思路参考：https://blog.csdn.net/weixin_40673608/article/details/83998859
     * 代码参考：https://blog.csdn.net/qq_41231926/article/details/82491091
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {

    }
}
