package com.proj.jonny.leetcode.array;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * Author: jonny
 * Time: 2020-04-18 22:39.
 */
public class Solution_34 {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(searchRange(new int[]{2, 2}, 2)));
    }

    public static int[] searchRange(int[] nums, int target) {
        return searchRange(nums, 0, nums.length - 1, target);
    }

    private static int[] searchRange(int[] nums, int left, int right, int target) {

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (left == right && nums[left] != target) {
                return new int[]{-1, -1};
            }
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                //nums[mid] == target
                int idx = mid;
                while (idx < nums.length && nums[idx] == target) {
                    idx++;
                }
                int max = idx - 1;

                idx = mid;
                while (idx >= 0 && idx < nums.length && nums[idx] == target) {
                    idx--;
                }
                int min = idx + 1;
                return new int[]{min, max};
            }
        }
        return new int[]{-1, -1};
    }

}
