package com.proj.jonny.leetcode.tree;

/**
 * 二叉树的最近公共祖先
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * <p>
 * Author: jonny
 * Time: 2020-04-19 22:36.
 */
public class Solution_236 {

    public static void main(String[] args) {
        TreeNode node = TreeNodeUtils.buildFrom(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
//        System.out.println(lowestCommonAncestor(node, new TreeNode(5), new TreeNode(1)));
        System.out.println(lowestCommonAncestor(node, new TreeNode(5), new TreeNode(4)));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //p 和 q 分别在左右两个子树中
        if (left != null && right != null) {
            return root;
        }
        // 在右子树中找到
        if (left == null && right != null) {
            return right;
        }
        // 在左子树中找到
        if (left != null && right == null) {
            return left;
        }
        return null;
    }

}
