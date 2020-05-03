package com.proj.jonny.leetcode.array;

import java.util.Map;
import java.util.TreeMap;

/**
 * 找出数组中的幸运数
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 * <p>
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 * <p>
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,2,3,4]
 * 输出：2
 * 解释：数组中唯一的幸运数是 2 ，因为数值 2 的出现频次也是 2 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,2,3,3,3]
 * 输出：3
 * 解释：1、2 以及 3 都是幸运数，只需要返回其中最大的 3 。
 * 示例 3：
 * <p>
 * 输入：arr = [2,2,2,3,3]
 * 输出：-1
 * 解释：数组中不存在幸运数。
 * 示例 4：
 * <p>
 * 输入：arr = [5]
 * 输出：-1
 * 示例 5：
 * <p>
 * 输入：arr = [7,7,7,7,7,7,7]
 * 输出：7
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 500
 * 1 <= arr[i] <= 500
 * <p>
 * Author: jonny
 * Time: 2020-05-03 12:01.
 */
public class Solution_1394 {


    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{2, 2, 3, 4}));
        System.out.println(findLucky(new int[]{1, 2, 2, 3, 3, 3}));
    }

    public static int findLucky(int[] arr) {
        Map<Integer, Integer> freq = new TreeMap<>();
        for (int num : arr) {
            if (freq.containsKey(num)) {
                freq.replace(num, freq.get(num) + 1);
            } else {
                freq.put(num, 1);
            }
        }

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                if (entry.getKey() > max) {
                    max = entry.getKey();
                }
            }
        }
        return max;
    }

}
