package com.ecnu.liu.algorithm.leetcode.weapon;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 示例 1:

 给定数组 nums = [1,1,2],

 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

 你不需要考虑数组中超出新长度后面的元素。
 示例 2:

 给定 nums = [0,0,1,1,1,2,2,3,3,4],

 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。

 你不需要考虑数组中超出新长度后面的元素。
 说明:

 为什么返回数值是整数，但输出的答案是数组呢?

 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

 你可以想象内部操作如下:

 // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 int len = removeDuplicates(nums);

 // 在函数里修改输入数组对于调用者是可见的。
 // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 for (int i = 0; i < len; i++) {
     print(nums[i]);
 }

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P26_RemoveDuplicatesFromSortedAarray {

    /**
     * 解法一
     * 双指针法，快慢指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;
        else if (len == 2) return (nums[0] == nums[1] ? 1 : 2);

        int left = 1;
        while (left < len && nums[left] != nums[left-1]) {
            left++;
        }
        if (left >= len) return left;
        int cur = nums[left];
        int right = left+1;

        while (left < len && right < len) {
            while (right < len && nums[right] == cur) {
                right++;
            }
            if (right >= len) break;
            cur = nums[right];
            nums[right] = nums[left];
            nums[left] = cur;
            right++;
            left++;
        }

        return left;
    }

    /**
     * 快慢指针
     * 优雅解法
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int i = 0;
        for (int j=1; j<nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
