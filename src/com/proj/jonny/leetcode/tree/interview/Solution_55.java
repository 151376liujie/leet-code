package com.proj.jonny.leetcode.tree.interview;

import com.proj.jonny.leetcode.tree.TreeNode;
import com.proj.jonny.leetcode.tree.TreeNodeUtils;

/**
 * Author: jonny
 * Time: 2020-04-19 20:31.
 */
public class Solution_55 {

    public static void main(String[] args) {
        TreeNode tree = TreeNodeUtils.buildFrom(3, 9, 20, null, null, 15, 7);
        System.out.println(maxDepth(tree));
    }

    /**
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     *
     * @param root
     * @return
     */

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = 1 + maxDepth(root.left);
        int rightDepth = 1 + maxDepth(root.right);
        return Math.max(leftDepth, rightDepth);
    }
}
