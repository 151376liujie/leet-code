package com.proj.jonny.leetcode.tree.interview;

import com.proj.jonny.leetcode.tree.TreeNode;
import com.proj.jonny.leetcode.tree.TreeNodeUtils;

/**
 * 🌲的子结构
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 * <p>
 * Author: jonny
 * Time: 2020-05-09 23:24.
 */
public class Solution_26 {

    public static void main(String[] args) {
        TreeNode a = TreeNodeUtils.buildFrom(1, 2, 3);
        TreeNode b = TreeNodeUtils.buildFrom(3, 1);
        System.out.println(isSubStructure(a, b));

        a = TreeNodeUtils.buildFrom(3, 4, 5, 1, 2);
        b = TreeNodeUtils.buildFrom(4, 1);
        System.out.println(isSubStructure(a, b));
    }

    public static boolean isSubStructure(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return false;
        }

        return hasAContainsB(a, b) || isSubStructure(a.left, b) || isSubStructure(a.right, b);
    }

    /**
     * 判断以a节点为根的🌲是否包含二叉树b
     *
     * @param a
     * @param b
     * @return
     */
    private static boolean hasAContainsB(TreeNode a, TreeNode b) {

        if (b == null) {
            return true;
        }

        if (a == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }
        return hasAContainsB(a.left, b.left) && hasAContainsB(a.right, b.right);
    }

}
