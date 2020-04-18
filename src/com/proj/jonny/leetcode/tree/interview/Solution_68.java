package com.proj.jonny.leetcode.tree.interview;

import com.proj.jonny.leetcode.tree.TreeNode;
import com.proj.jonny.leetcode.tree.TreeNodeUtils;

/**
 * 二叉搜索树的最近公共祖先
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
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
 */
public class Solution_68 {
    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildFrom(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        System.out.println(lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4)));

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if ((root.left == p && root.right == q) || (root.left == q && root.right == p)) {
            return root;
        }
        //root节点大小比p、q都大，那么去root的左子树继续寻找
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            //root节点大小比p、q都小，那么去root的右子树继续寻找
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

}
