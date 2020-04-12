package com.proj.jonny.leetcode.tree;

/**
 * Author: jonny
 * Time: 2020-04-12 09:54.
 */
public class TreeNodeUtils {

    public static void main(String[] args) {
        System.out.println(buildFrom(1, -1, 2));
        System.out.println(buildFrom(1, 2, 3, -1, 5, -1, 6));
    }

    /**
     * 根据整型数组构建一棵二叉树，方便写测试用例
     *
     * @param arr 空的子节点用-1的值来取代
     * @return
     */
    public static TreeNode buildFrom(int... arr) {
        if (arr.length == 0) {
            return null;
        }
        TreeNode root = buildFromIndex(0, arr);

        return root;
    }

    private static TreeNode buildFromIndex(int index, int[] arr) {
        if (index >= arr.length || arr[index] == -1) {
            return null;
        }

        TreeNode node = new TreeNode(arr[index]);
        node.left = buildFromIndex(leftChild(index), arr);
        node.right = buildFromIndex(rightChild(index), arr);
        return node;
    }

    private static int leftChild(int index) {
        return 2 * index + 1;
    }

    private static int rightChild(int index) {
        return 2 * index + 2;
    }

}
