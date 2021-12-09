package com.proj.jonny.leetcode.array;

import java.util.Arrays;

/**
 * 各种排序算法
 */
public class Sorts {


    public static void main(String[] args) {
        int[] array = new int[]{9, 4, 2, 5, 6, 1, 3};
        System.out.println("before sort: " + Arrays.toString(array));
        selectionSort(array);
        System.out.println("after selection sort: " + Arrays.toString(array));
//        bubbleSort(array);
//        System.out.println("after bubble sort: " + Arrays.toString(array));
//        insertionSort(array);
//        System.out.println("after insertion sort: " + Arrays.toString(array));

//        for (int i = 0; i < 1000; i++) {
//            List<Integer> list = new ArrayList<>();
//            IntStream.range(1, 50).forEach(idx -> list.add(new Random().nextInt(100)));
//            Integer[] integers = list.toArray(new Integer[0]);
//            selectionSort(integers);
//            System.out.println("after selection sort: " + Arrays.toString(integers));
//            for (int i1 = 0; i1 < integers.length - 1; i1++) {
//                if (integers[i1] > integers[i1 + 1]) {
//                    throw new IllegalStateException();
//                }
//            }
//        }
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

    /**
     * 思路：将数组分为两个区，待排序区和已排序区，
     * 每次从待排序区中找出最小值，然后跟已排序区元素比较
     * 如果待排序区的最小值小于已排序区元素，交换位置
     *
     * @param arr
     */
    private static void selectionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int indexOfMin = min(arr, i);
            if (arr[indexOfMin] < arr[j]) {
                int tmp = arr[j];
                arr[j] = arr[indexOfMin];
                arr[indexOfMin] = tmp;
            }
        }
    }

    private static int min(int[] arr, int startIndex) {
        int min = startIndex;
        for (int i = startIndex + 1; i < arr.length; i++) {
            if (arr[min] > arr[i]) {
                min = i;
            }
        }
        return min;
    }

    /**
     * 归并排序
     *
     * @param arr
     */
    private static void mergerSort(int[] arr) {

    }

    /**
     * 快速排序
     *
     * @param arr
     */
    private static void quickSort(int[] arr) {

    }

}
