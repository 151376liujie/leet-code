package com.proj.jonny.leetcode.array;

import java.util.Arrays;

/**
 * 移动零
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * Author: jonny
 * Time: 2020-04-19 14:01.
 */
public class Solution_283 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int k = i;
            while (k < nums.length) {
                if (nums[k] == 0) {
                    k++;
                } else {
                    if (i != k) {
                        int tmp = nums[i];
                        nums[i] = nums[k];
                        nums[k] = tmp;
                    }
                    break;
                }
            }
        }
    }

    public static void moveZeroes2(int[] nums) {

        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
