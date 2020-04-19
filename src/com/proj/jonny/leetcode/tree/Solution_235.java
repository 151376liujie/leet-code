package com.proj.jonny.leetcode.tree;

/**
 * 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 * <p>
 * 说明:
 * <p>
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * <p>
 * Author: jonny
 * Time: 2020-04-19 22:36.
 */
public class Solution_235 {

    public static void main(String[] args) {
        TreeNode node = TreeNodeUtils.buildFrom(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
//        System.out.println(lowestCommonAncestor(node, new TreeNode(2), new TreeNode(4)));
//        System.out.println(lowestCommonAncestor(node, new TreeNode(0), new TreeNode(5)));
//        System.out.println(lowestCommonAncestor(node, new TreeNode(0), new TreeNode(7)));
        System.out.println(lowestCommonAncestor(node, new TreeNode(3), new TreeNode(7)));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);

        if (root.val > max) {
            return lowestCommonAncestor(root.left, p, q);
        }

        if (root.val < min) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

}
