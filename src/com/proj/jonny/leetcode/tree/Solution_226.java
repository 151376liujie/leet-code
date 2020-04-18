package com.proj.jonny.leetcode.tree;

/**
 * 翻转二叉树
 * <p>
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * Author: jonny
 * Time: 2020-04-18 16:12.
 */
public class Solution_226 {


    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildFrom(4, 2, 7, 1, 3, 6, 9);
        System.out.println(invertTree(root));
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.right = invertTree(left);
        root.left = invertTree(right);

        return root;
    }

}
