package com.proj.jonny.leetcode.tree;

/**
 * 把二叉搜索树转换为累加树
 * <p>
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 *  
 * <p>
 * 例如：
 * <p>
 * 输入: 原始二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 * <p>
 * Author: jonny
 * Time: 2020-04-20 22:14.
 */
public class Solution_538 {

    private static int shareSum = 0;

    public static void main(String[] args) {
        TreeNode node = TreeNodeUtils.buildFrom(5, 2, 13);
//        System.out.println(convertBST(node));
//        node = TreeNodeUtils.buildFrom( 2, 1);
//        System.out.println(convertBST(node));

        node = TreeNodeUtils.buildFrom(2, 0, 3, -4, 1);
        System.out.println(convertBST(node));
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        midOrder(root);
        return root;
    }

    public static void midOrder(TreeNode node) {
        if (node == null) return;
        midOrder(node.right);
        node.val = node.val + shareSum;
        shareSum = node.val;
        midOrder(node.left);
    }

}
