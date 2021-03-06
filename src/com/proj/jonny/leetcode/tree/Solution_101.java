package com.proj.jonny.leetcode.tree;

/**
 * 对称二叉树
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *  
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 * <p>
 * Author: jonny
 * Time: 2020-04-18 19:10.
 */
public class Solution_101 {

    public static void main(String[] args) {
        TreeNode tree = TreeNodeUtils.buildFrom(1, 2, 2, 3, 4, 4, 3);
        System.out.println(isSymmetric(tree));

        tree = TreeNodeUtils.buildFrom(1, 2, 2, null, 3, null, 3);
        System.out.println(isSymmetric(tree));
        tree = TreeNodeUtils.buildFrom(1, 2, 3);
        System.out.println(isSymmetric(tree));
    }


    /**
     * *     1
     * *    / \
     * *   2   2
     * *  / \ / \
     * * 3  4 4  3
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }

        if (left != null && right == null) {
            return false;
        }

        if (left == null && right == null) {
            return true;
        }
        if (left.val == right.val) {
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }
}
