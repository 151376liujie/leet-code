package com.proj.jonny.leetcode.array.interview;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] ints = printMatrix(matrix);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] printMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int x = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];
        while (true) {
            // 从左到右
            for (int i = left; i <= right; i++) {
                res[x++] = matrix[top][i];
            }
            if (++top > bottom) {
                break;
            }
            // 从上到下
            for (int i = top; i <= bottom; i++) {
                res[x++] = matrix[i][right];
            }
            if (left > --right) {
                break;
            }

            //从右到左
            for (int i = right; i >= left; i--) {
                res[x++] = matrix[bottom][i];
            }
            if (top > --bottom) {
                break;
            }
            //从下到上
            for (int i = bottom; i >= top; i--) {
                res[x++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
