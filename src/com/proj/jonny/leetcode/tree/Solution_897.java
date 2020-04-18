package com.proj.jonny.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 递增顺序查找树
 * <p>
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * <p>
 * 提示：
 * <p>
 * 给定树中的结点数介于 1 和 100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 */
public class Solution_897 {

    public static void main(String[] args) {
        System.out.println(increasingBST(TreeNodeUtils.buildFrom(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9)));
    }

    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        TreeNode newRoot = new TreeNode(list.get(0));
        TreeNode cur = newRoot;
        for (int i = 1; i < list.size(); i++) {
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
        return newRoot;
    }

    private static void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

}
