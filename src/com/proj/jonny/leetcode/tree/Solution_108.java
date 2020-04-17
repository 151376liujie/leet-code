package com.proj.jonny.leetcode.tree;

/**
 * 将有序数组转换为二叉搜索树
 * <p>
 * <p>
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * <p>
 * Author: jonny
 * Time: 2020-04-17 23:25.
 */
public class Solution_108 {

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{1, 2, 3, 4, 5});
        System.out.println(root);
    }

    /**
     * 使用指定数组构建二叉树
     *
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    /**
     * 使用指定数组，在[left, right)区间内构建二叉树
     *
     * @param nums
     * @param left  左区间，包含
     * @param right 右区间，不包含
     * @return
     */
    private static TreeNode buildTree(int[] nums, int left, int right) {

        if (left >= right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }
}
