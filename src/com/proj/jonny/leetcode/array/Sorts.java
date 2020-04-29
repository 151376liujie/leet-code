package com.proj.jonny.leetcode.array;

import java.util.Arrays;

/**
 * 各种排序算法
 */
public class Sorts {


    public static void main(String[] args) {
        int[] array = new int[]{9, 4, 5, 6, 1, 2, 3};
        System.out.println("before sort: " + Arrays.toString(array));
//        bubbleSort(array);
//        System.out.println("after bubble sort: " + Arrays.toString(array));
        insertionSort(array);
        System.out.println("after insertion sort: " + Arrays.toString(array));
    }

    private static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 思路：将数组分为两个区间，已排序区间和待排序区间，
     * 将待排序区间内的元素不断插入已排序区间
     *
     * @param arr
     */
    private static void insertionSort(int[] arr) {

        //待排序区间从1开始
        for (int i = 1; i < arr.length; i++) {
            //已排序区间的最大值，初始的时候只有数组第一个元素是有序的
            int sortedIndex = i - 1;
            //记录下待排序区间内当前元素值
            int value = arr[i];
            while (sortedIndex >= 0) {
                //只要待排序区的当前元素值比已排序区间内的值小，就腾位置给待排序的当前元素
                if (arr[sortedIndex] > value) {
                    arr[sortedIndex + 1] = arr[sortedIndex];
                } else {
                    break;
                }
                sortedIndex--;
            }
            //待排序元素放到合适位置
            arr[sortedIndex + 1] = value;
        }
    }


    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort2(int[] arr) {
        if (arr.length <= 1) return;

        for (int i = 1; i < arr.length; ++i) {
            int value = arr[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];  // 数据移动
                } else {
                    break;
                }
            }
            arr[j + 1] = value; // 插入数据
        }
    }

}
