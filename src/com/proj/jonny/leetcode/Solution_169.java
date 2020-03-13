package com.proj.jonny.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例：
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例：
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */

public class Solution_169 {

    public static void main(String[] args) {

        int[] nums = {3,2,3};
        System.out.println(majorityElement(nums));
        int[] nums2 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums2));

    }


    public static int majorityElement(int[] nums) {

        Map<Integer,Integer> numberCountMap = new HashMap<>();

        for (int num : nums) {
            if (!numberCountMap.containsKey(num)) {
                numberCountMap.put(num, 1);
            } else {
                numberCountMap.replace(num, numberCountMap.get(num) + 1);
            }
        }
        int count = nums.length / 2;

        for (Map.Entry<Integer, Integer> entry : numberCountMap.entrySet()) {
            if (entry.getValue() > count){
                return entry.getKey();
            }
        }
        return -1;
    }

}
