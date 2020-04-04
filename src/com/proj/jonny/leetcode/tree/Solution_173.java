package com.proj.jonny.leetcode.tree;

import java.util.LinkedList;

/**
 * 二叉搜索树迭代器
 * <p>
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * <p>
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * <p>
 * Author: jonny
 * Time: 2020-04-04 10:58.
 */
public class Solution_173 {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(7);
        TreeNode three = new TreeNode(3);
        TreeNode fifty = new TreeNode(15);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        root.left = three;
        root.right = fifty;
        fifty.left = nine;
        fifty.right = twenty;


        BSTIterator iterator = new BSTIterator(root);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    static class BSTIterator {

        private LinkedList<Integer> queue = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            inOrder(root);
        }

        private void inOrder(TreeNode node) {
            if (node == null) {
                return;
            }
            if (node.left != null) {
                inOrder(node.left);
            }
            queue.addLast(node.val);
            if (node.right != null) {
                inOrder(node.right);
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return queue.removeFirst();
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}


