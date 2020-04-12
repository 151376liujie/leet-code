package com.proj.jonny.leetcode.array;

import java.util.HashSet;

/**
 * 检查整数及其两倍数是否存在
 * <p>
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 * <p>
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * 示例 2：
 * <p>
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * 示例 3：
 * <p>
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 500
 * -10^3 <= arr[i] <= 10^3
 */
public class Solution_1346 {

    public static void main(String[] args) {
//        System.out.println(checkIfExist(new int[]{10, 2, 5, 3}));
//        System.out.println(checkIfExist(new int[]{7, 1, 14, 11}));
//        System.out.println(checkIfExist(new int[]{3, 1, 7, 11}));
        System.out.println(checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
        System.out.println(checkIfExist(new int[]{0, 0}));

    }

    public static boolean checkIfExist(int[] arr) {
        //key :element in arr;
        HashSet<Integer> set = new HashSet<>();
        for (int value : arr) {
            if (set.contains(value * 2) || (value % 2 == 0 && set.contains(value / 2))) {
                return true;
            }
            set.add(value);
        }
        return false;
    }
}
