package com.proj.jonny.leetcode.array;

import java.util.Arrays;

/**
 * 将数组分成和相等的三个部分
 * <p>
 * <p>
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * <p>
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 示例 2：
 * <p>
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 * <p>
 * Author: jonny
 * Time: 2020-04-12 22:56.
 */
public class Solution_1013 {

    public static void main(String[] args) {
        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1}));
        System.out.println(canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1}));
        System.out.println(canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4}));
        System.out.println(canThreePartsEqualSum(new int[]{10, -10, 10, -10, 10, -10, 10, -10}));
    }

    public static boolean canThreePartsEqualSum(int[] A) {

        int sum = Arrays.stream(A).sum();
        if (sum % 3 != 0) {
            return false;
        }
        //每个部分的和
        int eachPart = sum / 3;
        //每段的和
        int sum_ = 0;
        //已经找到的段数
        int part = 0;
        for (int i = 0; i < A.length; i++) {

            sum_ += A[i];
            if (sum_ == eachPart) {
                //计数器重置
                sum_ = 0;
                part++;
            }
            //如果找到两段了，那剩下的一段的和肯定等于eachPart
            if (part == 2 && i != A.length - 1) {
                return true;
            }
        }

        return part == 3;
    }

}
