package com.proj.jonny.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉搜索树的范围和
 * <p>
 * 给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
 * <p>
 * 二叉搜索树保证具有唯一的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
 * 输出：32
 * 示例 2：
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * 输出：23
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的结点数量最多为 10000 个。
 * 最终的答案保证小于 2^31。
 * <p>
 * Author: jonny
 * Time: 2020-04-18 10:29.
 */
public class Solution_938 {

    public static void main(String[] args) {
        TreeNode root = TreeNodeUtils.buildFrom(10, 5, 15, 3, 7, null, 18);
//        System.out.println(rangeSumBST(root, 7, 15));
        System.out.println(rangeSumBST(root, 5, 18));


        root = TreeNodeUtils.buildFrom(10, 5, 15, 3, 7, 13, 18, 1, null, 6);
        System.out.println(rangeSumBST2(root, 6, 10));
    }

    /**
     * 10
     * /  \
     * 5    15
     * / \  /  \
     * 3  7 13   18
     * /  /
     * 1  6
     *
     * @param node
     * @param L
     * @param R
     * @return
     */
    public static int rangeSumBST(TreeNode node, int L, int R) {
        List<Integer> list = new ArrayList<>();
        inorder(node, L, R, list);
//        System.out.println(Arrays.toString(list.toArray()));
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    private static void inorder(TreeNode node, int left, int right, List<Integer> list) {

        if (node == null) {
            return;
        }

        inorder(node.left, left, right, list);
        if (node.val >= left && node.val <= right) {
            list.add(node.val);
        }
        inorder(node.right, left, right, list);
    }

    public static int rangeSumBST2(TreeNode node, int L, int R) {
        if (node == null) {
            return 0;
        }

        if (node.val > R) {
            return rangeSumBST(node.left, L, R);
        } else if (node.val < L) {
            return rangeSumBST(node.right, L, R);
        }
        // 当前节点的值在L 和R 之间
        return node.val + rangeSumBST2(node.left, L, R) + rangeSumBST2(node.right, L, R);
    }

}
