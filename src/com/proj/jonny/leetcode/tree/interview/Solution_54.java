package com.proj.jonny.leetcode.tree.interview;

import com.proj.jonny.leetcode.tree.TreeNode;
import com.proj.jonny.leetcode.tree.TreeNodeUtils;

import java.util.ArrayList;

/**
 * 二叉搜索树的第k大节点
 * <p>
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * Author: jonny
 * Time: 2020-04-24 23:08.
 */
public class Solution_54 {

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildFrom(3, 1, 4, null, 2);
        System.out.println(kthLargest(root, 1));
    }

    public static int kthLargest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        kthLargest(root, k, list);
        System.out.println(list.toString());
        return list.get(k - 1);
    }

    private static void kthLargest(TreeNode root, int k, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        kthLargest(root.right, k, list);
        list.add(root.val);
        if (list.size() == k) {
            return;
        }
        kthLargest(root.left, k, list);
    }

}
