package com.proj.jonny.leetcode.tree;

/**
 * 单值二叉树
 * <p>
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * <p>
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * <p>
 * <p>
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * <p>
 * 输入：[2,2,2,5,2]
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 给定树的节点数范围是 [1, 100]。
 * 每个节点的值都是整数，范围为 [0, 99] 。
 * Author: jonny
 * Time: 2020-04-27 21:52.
 */
public class Solution_965 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(1);
        left.left = new TreeNode(1);
        left.right = new TreeNode(1);
        right.right = new TreeNode(1);
        root.left = left;
        root.right = right;
        System.out.println(isUnivalTree(root));

        root = new TreeNode(2);
        left = new TreeNode(2);
        right = new TreeNode(2);
        left.left = new TreeNode(5);
        left.right = new TreeNode(2);
        root.left = left;
        root.right = right;
        System.out.println(isUnivalTree(root));
    }

    public static boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        return preOrder(root, root.val);
    }

    private static boolean preOrder(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        if (node.val != val) {
            return false;
        }
        return preOrder(node.left, val) && preOrder(node.right, val);
    }

}
