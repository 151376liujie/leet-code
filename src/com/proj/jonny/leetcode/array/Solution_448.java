package com.proj.jonny.leetcode.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 找到所有数组中消失的数字
 * <p>
 * <p>
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * 输出:
 * [5,6]
 * <p>
 * Author: jonny
 * Time: 2020-04-21 08:28.
 */
public class Solution_448 {

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(findDisappearedNumbers2(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            map.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!map.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 数组中的每个元素设为num, 遍历每一个元素。将num-1位置上的元素设为负数（乘以-1），
     * 遍历完后，元素为正数的对应索引 + 1就是缺失的数字
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers2(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }

}
